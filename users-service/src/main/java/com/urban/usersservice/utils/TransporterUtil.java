package com.urban.usersservice.utils;

import com.urban.usersservice.dtos.PersonOutputDto;
import com.urban.usersservice.dtos.transporter.TransporterInputDto;
import com.urban.usersservice.entities.Transporter;
import com.urban.usersservice.entities.person.PersonData;

import java.util.Optional;

public class TransporterUtil {

    public static Transporter setTransportAttributes(TransporterInputDto transDto){
        Transporter transporter = new Transporter();
        transporter.setName(transDto.getName());
        transporter.setAddress(transDto.getAddress());
        transporter.setEmail(transDto.getEmail());
        transporter.setPassword(transDto.getPassword());
        transporter.setIdentity(transDto.getIdentity());
        transporter.setPicture(transDto.getPicture());
        transporter.setPhone(transDto.getPhone());
        transporter.setVehicle(transDto.getVehicle());
        return transporter;
    }

    public static boolean checkTransporterFields(TransporterInputDto trDto){ // from VehicleInputDto
        return (trDto.getName() == null || trDto.getName().isEmpty()
                || trDto.getEmail() == null || trDto.getEmail().isEmpty()
                || trDto.getPhone() == null || trDto.getPhone().isEmpty()
                || trDto.getAddress() == null || trDto.getAddress().isEmpty()
                || trDto.getPicture() == null || trDto.getPicture().isEmpty()
                || trDto.getIdentity() == null || trDto.getIdentity().isEmpty()
                || trDto.getPassword() == null || trDto.getPassword().isEmpty()
                || trDto.getVehicle().getName() == null || trDto.getVehicle().getName().isEmpty()
                || trDto.getVehicle().getIdentify() == null || trDto.getVehicle().getIdentify().isEmpty()
        );
    }
}
