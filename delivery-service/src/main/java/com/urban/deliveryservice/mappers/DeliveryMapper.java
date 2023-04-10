package com.urban.deliveryservice.mappers;

import com.urban.deliveryservice.dtos.DeliveryOutputDto;
import com.urban.deliveryservice.entities.Delivery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DeliveryMapper {
    public DeliveryOutputDto fromDeliveryEntity(Delivery delivery){
        DeliveryOutputDto deliveryDto = new DeliveryOutputDto();
        BeanUtils.copyProperties(delivery, deliveryDto);
        return deliveryDto;
    }
}
