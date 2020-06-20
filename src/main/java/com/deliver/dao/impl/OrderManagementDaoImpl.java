package com.deliver.dao.impl;

import com.deliver.commons.SampleData;
import com.deliver.dao.OrderManagementDao;
import com.deliver.model.entity.OrderDeliveryManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderManagementDaoImpl implements OrderManagementDao {

    private SampleData sampleData;

    @Autowired
    public OrderManagementDaoImpl(SampleData sampleData,
                                  OrderManagementDao orderDetailsDao){
        this.sampleData = sampleData;
    }

    @Override
    public void addNewOrderDelivery(OrderDeliveryManagement orderDeliveryManagement){
        if(orderDeliveryManagement != null && sampleData.getOrderManagementMap() != null){
            sampleData.getOrderManagementMap().put(orderDeliveryManagement.getOrderId(), orderDeliveryManagement);
        }

    }

    @Override
    public OrderDeliveryManagement getOrderManagementDetailsByDeliveryPersonId(String deliveryPersonId){
        if(deliveryPersonId != null && !deliveryPersonId.isEmpty() && sampleData.getDeliveryPersonDetailsMap() != null){
           return sampleData.getOrderManagementMap().get(deliveryPersonId);
        }
        return null;
    }



}
