package com.deliver.service;

import com.deliver.request.DeliveryAssignRequest;
import com.deliver.response.DeliveryPersonCurrentStatusResponse;
import com.deliver.response.RestResponse;


public interface DeliveryService {

    RestResponse assignDelivery(DeliveryAssignRequest requestBody);
    DeliveryPersonCurrentStatusResponse getCurrentStatusOfDeliveryPerson(String seliveryPersonId);
}
