package com.urban.vehicleservice.services;

import com.urban.vehicleservice.dtos.VehicleInputDto;
import com.urban.vehicleservice.dtos.VehicleOutputDto;
import com.urban.vehicleservice.entities.Vehicle;
import com.urban.vehicleservice.exceptions.IncompleteInfos;
import com.urban.vehicleservice.exceptions.VehicleIdentifyExistException;
import com.urban.vehicleservice.exceptions.VehicleNotFoundException;

import java.util.List;

public interface VehicleService {
    List<Vehicle> listAll();
    VehicleOutputDto addVehicle(VehicleInputDto vehicle) throws VehicleIdentifyExistException, IncompleteInfos;
    VehicleOutputDto updateVehicle(Long vehicleId, VehicleInputDto vehicle) throws VehicleNotFoundException, VehicleIdentifyExistException, IncompleteInfos;
    VehicleOutputDto searchVehicle(Long vehicleId) throws VehicleNotFoundException;
    void deleteVehicle(Long vehicleId) throws VehicleNotFoundException;
}
