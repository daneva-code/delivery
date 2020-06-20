package com.deliver.response;

public class DeliveryPersonCurrentStatusResponse {

    private String status;

    private String currentOrderId;

    private String curentOrderStatus;

    private String currentOrderDeliveryTimeLeft;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentOrderId() {
        return currentOrderId;
    }

    public void setCurrentOrderId(String currentOrderId) {
        this.currentOrderId = currentOrderId;
    }

    public String getCurentOrderStatus() {
        return curentOrderStatus;
    }

    public void setCurentOrderStatus(String curentOrderStatus) {
        this.curentOrderStatus = curentOrderStatus;
    }

    public String getCurrentOrderDeliveryTimeLeft() {
        return currentOrderDeliveryTimeLeft;
    }

    public void setCurrentOrderDeliveryTimeLeft(String currentOrderDeliveryTimeLeft) {
        this.currentOrderDeliveryTimeLeft = currentOrderDeliveryTimeLeft;
    }
}
