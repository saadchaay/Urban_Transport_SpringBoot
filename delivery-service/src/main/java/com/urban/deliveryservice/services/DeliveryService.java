package com.urban.deliveryservice.services;

import com.urban.deliveryservice.dtos.DeliveryInputDto;
import com.urban.deliveryservice.dtos.DeliveryOutputDto;
import com.urban.deliveryservice.exceptions.DeliveryFieldExistException;
import com.urban.deliveryservice.exceptions.DeliveryNotFoundException;
import com.urban.deliveryservice.exceptions.IncompleteInfos;

import java.util.List;

public interface DeliveryService {

    List<DeliveryOutputDto> listAll();
    DeliveryOutputDto addDelivery(DeliveryInputDto delivery) throws IncompleteInfos;
    DeliveryOutputDto updateDelivery(Long deliveryId, DeliveryInputDto user) throws IncompleteInfos, DeliveryFieldExistException, DeliveryNotFoundException;
    DeliveryOutputDto searchDelivery(Long deliveryId) throws DeliveryNotFoundException;
    void deleteDelivery(Long deliveryId) throws DeliveryNotFoundException;

}
