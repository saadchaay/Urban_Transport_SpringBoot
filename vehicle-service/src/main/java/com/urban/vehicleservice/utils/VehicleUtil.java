package com.urban.vehicleservice.utils;

import com.urban.vehicleservice.dtos.VehicleInputDto;
import com.urban.vehicleservice.entities.Vehicle;

import java.util.Optional;

public class VehicleUtil {

    public static boolean checkVehicleField(VehicleInputDto vehicleInputDto){ // from VehicleInputDto
        return (vehicleInputDto.getIdentify() == null || vehicleInputDto.getIdentify().isEmpty()
                || vehicleInputDto.getName() == null || vehicleInputDto.getName().isEmpty());
    }

    public static Vehicle setVehicleAttribute(VehicleInputDto vehicleInputDto, Long id){
        Vehicle vehicle = new Vehicle();
        if( id != null)
            vehicle.setId(id);
        vehicle.setName(vehicleInputDto.getName());
        vehicle.setIdentify(vehicleInputDto.getIdentify());
        return vehicle;
    }
}
