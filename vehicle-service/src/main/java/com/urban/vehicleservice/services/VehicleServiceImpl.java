package com.urban.vehicleservice.services;

import com.urban.vehicleservice.dtos.VehicleInputDto;
import com.urban.vehicleservice.dtos.VehicleOutputDto;
import com.urban.vehicleservice.entities.Vehicle;
import com.urban.vehicleservice.exceptions.IncompleteInfos;
import com.urban.vehicleservice.exceptions.VehicleIdentifyExistException;
import com.urban.vehicleservice.exceptions.VehicleNotFoundException;
import com.urban.vehicleservice.mappers.VehicleMapper;
import com.urban.vehicleservice.repositories.VehicleRepos;
import com.urban.vehicleservice.utils.VehicleUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepos vehicleRepos;
    private VehicleMapper vehicleMapper;

    @Override
    public List<Vehicle> listAll() {
        return vehicleRepos.findAll();
    }

    @Override
    public VehicleOutputDto addVehicle(VehicleInputDto vehicleDto) throws VehicleIdentifyExistException, IncompleteInfos {
        if (VehicleUtil.checkVehicleField(vehicleDto))
            throw new IncompleteInfos("Missing Fields!!!!!");

        Vehicle vehicleCheckIdentify = vehicleRepos.findVehicleByIdentify(vehicleDto.getIdentify());

        if(vehicleCheckIdentify != null)
            throw new VehicleIdentifyExistException(vehicleDto.getIdentify());

        Vehicle vehicle = VehicleUtil.setVehicleAttribute(vehicleDto, null);
        return vehicleMapper.fromVehicle(vehicleRepos.save(vehicle));
    }

    @Override
    public VehicleOutputDto updateVehicle(Long vehicleId, VehicleInputDto vehicle) throws VehicleNotFoundException, VehicleIdentifyExistException, IncompleteInfos {
        return null;
    }

    @Override
    public VehicleOutputDto searchVehicle(Long vehicleId) throws VehicleNotFoundException {
        return null;
    }

    @Override
    public void deleteVehicle(Long vehicleId) throws VehicleNotFoundException {

    }
}
