package com.urban.vehicleservice.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @GetMapping("vehicle-test")
    public ResponseEntity vehicleTest(){
        return ResponseEntity.ok("Test Successfully");
    }
}
