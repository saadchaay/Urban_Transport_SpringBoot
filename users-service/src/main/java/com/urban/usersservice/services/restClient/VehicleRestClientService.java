package com.urban.usersservice.services.restClient;

import com.urban.usersservice.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "vehicle-service")
public interface VehicleRestClientService {
    @GetMapping("/vehicles/{id}?projection=fullVehicle")
    Vehicle getVehicle(@PathVariable Long id);

    @PostMapping("/vehicles")
    Vehicle addVehicle(@RequestBody Vehicle vehicle);

    // if there are list of vehicles
//    @GetMapping("vehicles?projection=fullVehicle")
//    public PagedModel<Vehicle> listVehicles();
}
