package com.urban.usersservice.services.restClient;

import com.urban.usersservice.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "vehicle-service")
public interface VehicleRestClientService {
    @GetMapping("/vehicles/{id}")
    Vehicle getVehicle(@PathVariable Long id);

    @PostMapping("/vehicles")
    Vehicle addVehicle(@RequestBody Vehicle vehicle);

    @PutMapping("/vehicles/{id}")
    Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle);

    @DeleteMapping("/vehicles/{id}")
    void deleteVehicle(@PathVariable Long id);

    // if there are list of vehicles
//    @GetMapping("vehicles?projection=fullVehicle")
//    public PagedModel<Vehicle> listVehicles();
}
