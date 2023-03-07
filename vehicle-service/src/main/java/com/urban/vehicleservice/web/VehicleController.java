package com.urban.vehicleservice.web;

import com.urban.vehicleservice.dtos.VehicleInputDto;
import com.urban.vehicleservice.dtos.VehicleOutputDto;
import com.urban.vehicleservice.exceptions.IncompleteInfos;
import com.urban.vehicleservice.exceptions.VehicleIdentifyExistException;
import com.urban.vehicleservice.services.VehicleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicles")
public class VehicleController {
    private VehicleServiceImpl vehicleService;

    @GetMapping("vehicle-test")
    public ResponseEntity vehicleTest(){
        return ResponseEntity.ok("Test Successfully");
    }

    @PostMapping
    public VehicleOutputDto save(@RequestBody VehicleInputDto vehicleDto) throws VehicleIdentifyExistException, IncompleteInfos {
        return vehicleService.addVehicle(vehicleDto);
    }
}
