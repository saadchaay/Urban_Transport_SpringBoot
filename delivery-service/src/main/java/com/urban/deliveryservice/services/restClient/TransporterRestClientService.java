package com.urban.deliveryservice.services.restClient;

import com.urban.deliveryservice.models.Transporter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "users-service")
public interface TransporterRestClientService {

    @GetMapping("/transporters/{id}")
    Transporter getVehicle(@PathVariable Long id);

}
