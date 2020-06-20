package com.deliver.dao.impl;


import com.deliver.commons.SampleData;
import com.deliver.dao.DeliveryPersonDetailsDao;
import com.deliver.model.entity.DeliveryPersonDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DeliveryPersonDetailsDaoImpl implements DeliveryPersonDetailsDao {

    private SampleData sampleData;

    public DeliveryPersonDetailsDaoImpl(SampleData sampleData){
        this.sampleData = sampleData;
    }

    @Override
    public DeliveryPersonDetails getDeliveryPersonDetailsById(String deliveryPersonId){
        if(sampleData != null && sampleData.getDeliveryPersonDetailsMap() != null){
            return sampleData.getDeliveryPersonDetailsMap().get(deliveryPersonId);
        }
        return null;

    }



}
