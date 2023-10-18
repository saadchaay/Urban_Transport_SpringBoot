package com.urban.deliveryservice.repos;

import com.urban.deliveryservice.dtos.DeliveryOutputDto;
import com.urban.deliveryservice.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findDeliveriesByTransporterId(Long id);
}
