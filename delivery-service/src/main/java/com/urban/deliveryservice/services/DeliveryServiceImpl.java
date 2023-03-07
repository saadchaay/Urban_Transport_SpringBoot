package com.urban.deliveryservice.services;

import com.urban.deliveryservice.entities.Delivery;
import com.urban.deliveryservice.repos.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private DeliveryRepository repository;

    @Override
    public List<Delivery> listAll() {
        return repository.findAll();
    }

}
