package com.deliver.controller;

import com.deliver.exceptions.BadRequestException;
import com.deliver.request.DeliveryAssignRequest;
import com.deliver.response.DeliveryPersonCurrentStatusResponse;
import com.deliver.response.RestResponse;
import com.deliver.service.DeliveryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DeliveryController {

    private final DeliveryService deliveryService;

    DeliveryController(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }


    @RequestMapping(value = "/delivery/assign" , method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RestResponse assignDeliveryToPerson(@RequestBody @Valid DeliveryAssignRequest requestBody) throws BadRequestException {
        return deliveryService.assignDelivery(requestBody);
    }

    @RequestMapping(value = "/delivery/person" , method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    DeliveryPersonCurrentStatusResponse getCurrentStatusOfDeliveryPerson(@RequestParam(value = "deliveryPersonId") String deliveryPersonId) {
        return deliveryService.getCurrentStatusOfDeliveryPerson(deliveryPersonId);
    }


}
