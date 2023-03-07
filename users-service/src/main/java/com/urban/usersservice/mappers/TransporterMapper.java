package com.urban.usersservice.mappers;

import com.urban.usersservice.dtos.transporter.TransporterOutputDto;
import com.urban.usersservice.entities.Transporter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TransporterMapper {
    public TransporterOutputDto fromTransporterEntity(Transporter transporter){
        TransporterOutputDto transporterDto = new TransporterOutputDto();
        BeanUtils.copyProperties(transporter, transporterDto);
        return transporterDto;
    }
}
