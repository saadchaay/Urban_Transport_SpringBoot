package com.urban.vehicleservice.mappers;

import com.urban.vehicleservice.dtos.VehicleOutputDto;
import com.urban.vehicleservice.entities.Vehicle;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VehicleMapper {
    public VehicleOutputDto fromVehicle(Vehicle vehicle){
        VehicleOutputDto vehicleOutputDto = new VehicleOutputDto();
        BeanUtils.copyProperties(vehicle, vehicleOutputDto);
        return vehicleOutputDto;
    }
}
