package com.urban.deliveryservice.services;

import com.urban.deliveryservice.dtos.DeliveryInputDto;
import com.urban.deliveryservice.dtos.DeliveryOutputDto;
import com.urban.deliveryservice.entities.Delivery;
import com.urban.deliveryservice.exceptions.DeliveryFieldExistException;
import com.urban.deliveryservice.exceptions.DeliveryNotFoundException;
import com.urban.deliveryservice.exceptions.IncompleteInfos;
import com.urban.deliveryservice.mappers.DeliveryMapper;
import com.urban.deliveryservice.repos.DeliveryRepository;
import com.urban.deliveryservice.utils.DeliveryUtil;
import com.urban.deliveryservice.utils.EnumValues;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private DeliveryRepository repository;
    private DeliveryMapper deliveryMapper;

    @Override
    public List<DeliveryOutputDto> listAll() {
        return repository.findAll()
                .stream().map(deliveryMapper::fromDeliveryEntity).toList();
    }

    @Override
    public DeliveryOutputDto addDelivery(DeliveryInputDto dlDto) throws IncompleteInfos {
        dlDto.setStatus(EnumValues.delivery_status.PENDING.toString());
        if(DeliveryUtil.checkDeliveryFields(dlDto))
            throw new IncompleteInfos("Missing Fields, Try to enter the empty fields!");

        Delivery delivery = DeliveryUtil.setDeliveryAttributes(dlDto, null);
        return deliveryMapper.fromDeliveryEntity(repository.save(delivery));
    }

    @Override
    public DeliveryOutputDto updateDelivery(Long deliveryId, DeliveryInputDto user) throws IncompleteInfos, DeliveryFieldExistException, DeliveryNotFoundException {
        return null;
    }

    @Override
    public DeliveryOutputDto searchDelivery(Long deliveryId) throws DeliveryNotFoundException {
        return null;
    }

    @Override
    public void deleteDelivery(Long deliveryId) throws DeliveryNotFoundException {

    }
}
