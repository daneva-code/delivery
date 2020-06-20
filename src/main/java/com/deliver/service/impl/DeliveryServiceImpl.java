package com.deliver.service.impl;

import com.deliver.dao.DeliveryPersonDetailsDao;
import com.deliver.dao.OrderManagementDao;
import com.deliver.exceptions.BadRequestException;
import com.deliver.exceptions.InternalServerErrorException;
import com.deliver.model.entity.DeliveryPersonDetails;
import com.deliver.model.entity.OrderDeliveryManagement;
import com.deliver.model.enums.DeliveryStatus;
import com.deliver.request.DeliveryAssignRequest;
import com.deliver.response.DeliveryPersonCurrentStatusResponse;
import com.deliver.response.RestResponse;
import com.deliver.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryServiceImpl.class);

    private final OrderManagementDao orderManagementDao;

    private final DeliveryPersonDetailsDao deliveryPersonDetailsDao;

    @Autowired
    public DeliveryServiceImpl(OrderManagementDao orderManagementDao,
                               DeliveryPersonDetailsDao deliveryPersonDetailsDao ){
        this.orderManagementDao = orderManagementDao;
        this.deliveryPersonDetailsDao = deliveryPersonDetailsDao;
    }

    //delivery is assigned immediatly or for future
    @Override
    public RestResponse assignDelivery(DeliveryAssignRequest requestBody){
        OrderDeliveryManagement existingOrderDeliveryManagement  = orderManagementDao.getOrderManagementDetailsByDeliveryPersonId(requestBody.getDeliveryPersonId());

        Date deliveryStartTime = new Date();
        String deliveryStatus = DeliveryStatus.DELIVERING.getValue();
        Long estimatedDeliveryTimeMinutes = calculateEstimatedDeliveryTime(requestBody.getDeliveryAddress());

        if(existingOrderDeliveryManagement != null && DeliveryStatus.DELIVERY_COMPLETED.getValue().equalsIgnoreCase(existingOrderDeliveryManagement.getStatus())){
            deliveryStartTime = null;
            deliveryStatus = DeliveryStatus.TO_BE_PICKED.getValue();
            estimatedDeliveryTimeMinutes += calculateRemainingDeliveryTime(existingOrderDeliveryManagement);
        }

        OrderDeliveryManagement orderDeliveryManagement = new OrderDeliveryManagement();
        orderDeliveryManagement.setOrderId(requestBody.getOrderId());
        orderDeliveryManagement.setDeliveryPersonId(requestBody.getDeliveryPersonId());
        orderDeliveryManagement.setDeliveryStartTime(deliveryStartTime);
        orderDeliveryManagement.setDeliveryEndTime(null);
        orderDeliveryManagement.setEstimatedDeliveryTime(estimatedDeliveryTimeMinutes);
        orderDeliveryManagement.setStatus(deliveryStatus);
        try{
            orderManagementDao.addNewOrderDelivery(orderDeliveryManagement);
        }catch (Exception e){
            LOGGER.error("error while assigning delivery request to {}", requestBody);
            LOGGER.error("error while assigning delivery",e);
            throw new InternalServerErrorException("delivery assigning failed");
        }

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message","delivery assigned");
        return new RestResponse(200,responseBody,null);

    }


    //current status of the delivery person is returned
    @Override
    public DeliveryPersonCurrentStatusResponse getCurrentStatusOfDeliveryPerson(String deliveryPersonId){
        DeliveryPersonDetails deliveryPersonDetails= deliveryPersonDetailsDao.getDeliveryPersonDetailsById(deliveryPersonId);
        if (deliveryPersonDetails == null){
            throw new BadRequestException("invalid delivery person id");
        }

        DeliveryPersonCurrentStatusResponse deliveryPersonCurrentStatus = new DeliveryPersonCurrentStatusResponse();
        deliveryPersonCurrentStatus.setStatus(deliveryPersonDetails.getStatus());
        OrderDeliveryManagement orderDeliveryManagement = orderManagementDao.getOrderManagementDetailsByDeliveryPersonId(deliveryPersonId);
        if(orderDeliveryManagement != null){
            deliveryPersonCurrentStatus.setCurentOrderStatus(orderDeliveryManagement.getStatus());
            if(orderDeliveryManagement.getDeliveryEndTime() != null){
                deliveryPersonCurrentStatus.setCurrentOrderDeliveryTimeLeft("00 minutes");
            }else{
                deliveryPersonCurrentStatus.setCurrentOrderDeliveryTimeLeft(calculateRemainingDeliveryTime(orderDeliveryManagement).toString()+"minutes");
            }
            deliveryPersonCurrentStatus.setCurrentOrderId(orderDeliveryManagement.getOrderId());
        }
        return deliveryPersonCurrentStatus;
    }


    //calculates remaining delivery time in minutes
    private Long calculateRemainingDeliveryTime(OrderDeliveryManagement orderDeliveryManagement){
        long duration  = new Date().getTime() - orderDeliveryManagement.getDeliveryStartTime().getTime();
        return orderDeliveryManagement.getEstimatedDeliveryTime()-(TimeUnit.MILLISECONDS.toMinutes(duration));
    }

    //calculates estimated delivery time in minutes on distance basis
    private Long calculateEstimatedDeliveryTime(String deliveryaddress){
        return 30L;
    }

}
