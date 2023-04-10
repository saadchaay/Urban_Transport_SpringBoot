package com.urban.deliveryservice.utils;

import com.urban.deliveryservice.dtos.DeliveryInputDto;
import com.urban.deliveryservice.entities.Delivery;

import java.util.Date;

public class DeliveryUtil {

    public static Delivery setDeliveryAttributes(DeliveryInputDto deliveryDto, Long deliveryId){
        Delivery delivery = new Delivery();
        if(deliveryId != null)
            delivery.setId(deliveryId);
        delivery.setDepart(deliveryDto.getDepart());
        delivery.setArrival(deliveryDto.getArrival());
        delivery.setDepartCity(deliveryDto.getDepartCity());
        delivery.setArrivalCity(deliveryDto.getArrivalCity());
        delivery.setDepartDate(deliveryDto.getDepartDate());
        delivery.setArrivalDate(deliveryDto.getArrivalDate());
        delivery.setPrice(deliveryDto.getPrice());
        delivery.setStatus(deliveryDto.getStatus());
        delivery.setTransporterId(deliveryDto.getTransporterId());
        return delivery;
    }

    public static boolean checkDeliveryFields(DeliveryInputDto dlDto){ // from VehicleInputDto
        return (dlDto.getDepart() == null || dlDto.getDepart().isEmpty()
                || dlDto.getArrival() == null || dlDto.getArrival().isEmpty()
                || dlDto.getDepartCity() == null || dlDto.getDepartCity().isEmpty()
                || dlDto.getArrivalCity() == null || dlDto.getArrivalCity().isEmpty()
                || dlDto.getDepartDate() == null
                || dlDto.getArrivalDate() == null
                || dlDto.getPrice() == null || dlDto.getPrice() == 0
                || dlDto.getStatus() == null || dlDto.getStatus().isEmpty()
                || dlDto.getTransporterId() == null
        );
    }

}
