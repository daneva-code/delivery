package com.deliver.model.enums;

import java.util.HashSet;
import java.util.Set;

public enum DeliveryStatus {

    TO_BE_PICKED ("TO_BE_PICKED"),
    DELIVERING ("DELIVERING"),
    DELIVERED("DELIVERED"),
    RETURNING("RETURNING"),
    DELIVERY_COMPLETED("DELIVERY_COMPLETED");


    private String value;

    private static Set<String> orderStatusSet;

    static {
        orderStatusSet = new HashSet<>();
        orderStatusSet.add("TO_BE_PICKED");
        orderStatusSet.add("DELIVERING");
        orderStatusSet.add("DELIVERED");
        orderStatusSet.add("RETURNING");
        orderStatusSet.add("DELIVERY_COMPLETED");
    }

    DeliveryStatus(String value){
        this.value=value;
    }

    public String getValue() {
        return this.value;
    }

    public static Set<String> getOrderStatusSet() {
        return orderStatusSet;
    }

}
