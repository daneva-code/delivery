package com.deliver.request;

import javax.validation.constraints.NotBlank;

public class UpdateOrderStatusRequest {

    @NotBlank(message = "Field can not be null or empty")
    private String orderId;

    @NotBlank(message = "Field can not be null or empty")
    private String status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
