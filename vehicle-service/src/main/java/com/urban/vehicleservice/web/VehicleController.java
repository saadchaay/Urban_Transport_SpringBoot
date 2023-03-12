package com.urban.vehicleservice.web;

import com.urban.vehicleservice.dtos.VehicleInputDto;
import com.urban.vehicleservice.dtos.VehicleOutputDto;
import com.urban.vehicleservice.exceptions.IncompleteInfos;
import com.urban.vehicleservice.exceptions.VehicleIdentifyExistException;
import com.urban.vehicleservice.exceptions.VehicleNotFoundException;
import com.urban.vehicleservice.services.VehicleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicles")
public class VehicleController {
    private VehicleServiceImpl vehicleService;

    @GetMapping("vehicle-test")
    public ResponseEntity vehicleTest(){
        return ResponseEntity.ok("Test Successfully");
    }

    @GetMapping
    public List<VehicleOutputDto> all(){
        return vehicleService.listAll();
    }

    @GetMapping("{id}")
    public VehicleOutputDto one(@PathVariable Long id) throws VehicleNotFoundException {
        return vehicleService.searchVehicle(id);
    }

    @PostMapping
    public VehicleOutputDto save(@RequestBody VehicleInputDto vehicleDto) throws VehicleIdentifyExistException, IncompleteInfos {
        return vehicleService.addVehicle(vehicleDto);
    }

    @PutMapping("/{id}")
    public VehicleOutputDto update(
            @PathVariable Long id,
            @RequestBody VehicleInputDto vehicleDto) throws VehicleNotFoundException, VehicleIdentifyExistException, IncompleteInfos {
        return vehicleService.updateVehicle(id, vehicleDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws VehicleNotFoundException {
        vehicleService.deleteVehicle(id);
    }
}
