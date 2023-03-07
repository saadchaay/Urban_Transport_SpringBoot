package com.urban.usersservice.utils;

import com.urban.usersservice.dtos.PersonOutputDto;
import com.urban.usersservice.entities.Transporter;

public class TransporterUtil {

    public static PersonOutputDto castOneObject(Transporter transporter){
        PersonOutputDto personDto = new PersonOutputDto();
        personDto.setId(transporter.getId());
        personDto.setName(transporter.getName());
        personDto.setAddress(transporter.getAddress());
        personDto.setEmail(transporter.getEmail());
        personDto.setPassword(transporter.getPassword());
        personDto.setIdentity(transporter.getIdentity());
        return personDto;
    }
}
