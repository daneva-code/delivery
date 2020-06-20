package com.deliver.dao;

import com.deliver.model.entity.OrderDeliveryManagement;

public interface OrderManagementDao {

    void addNewOrderDelivery(OrderDeliveryManagement orderDeliveryManagement);
    OrderDeliveryManagement getOrderManagementDetailsByDeliveryPersonId(String deliveryPersonId);

}
