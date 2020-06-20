package com.deliver.commons;

import com.deliver.model.entity.DeliveryPersonDetails;
import com.deliver.model.entity.OrderDeliveryManagement;

import java.util.HashMap;
import java.util.Map;

public class SampleData {

    private static Map<String, DeliveryPersonDetails> deliveryPersonDetailsMap;
    private static Map<String, OrderDeliveryManagement> orderManagementMap;

    static {
        deliveryPersonDetailsMap = new HashMap<>();
        DeliveryPersonDetails deliveryPersonDetails = new DeliveryPersonDetails();
        deliveryPersonDetails.setId("1");
        deliveryPersonDetails.setStatus("ACTIVE");
        deliveryPersonDetails.setPersonName("Prikshit");
        deliveryPersonDetails.setContact("9717971797");
        deliveryPersonDetailsMap.put(deliveryPersonDetails.getId(), deliveryPersonDetails);
    }

    public static Map<String, DeliveryPersonDetails> getDeliveryPersonDetailsMap() {
        return deliveryPersonDetailsMap;
    }

    public static Map<String, OrderDeliveryManagement> getOrderManagementMap() {
        return orderManagementMap;
    }


}
