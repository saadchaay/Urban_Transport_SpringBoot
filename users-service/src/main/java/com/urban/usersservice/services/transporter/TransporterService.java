package com.urban.usersservice.services.transporter;

import com.urban.usersservice.dtos.PersonInputDto;
import com.urban.usersservice.dtos.PersonOutputDto;
import com.urban.usersservice.dtos.transporter.TransporterInputDto;
import com.urban.usersservice.dtos.transporter.TransporterOutputDto;
import com.urban.usersservice.exceptions.IncompleteInfos;
import com.urban.usersservice.exceptions.PersonFieldExistException;
import com.urban.usersservice.exceptions.PersonNotFoundException;

import java.util.List;

public interface TransporterService {
    List<TransporterOutputDto> listAll();
    TransporterOutputDto addTransporter(TransporterInputDto transporter) throws IncompleteInfos, PersonFieldExistException;
    TransporterOutputDto updateTransporter(Long transId, TransporterInputDto transporter) throws IncompleteInfos, PersonFieldExistException, PersonNotFoundException;
    TransporterOutputDto searchTransporter(Long transId) throws PersonNotFoundException;
    void deleteTransporter(Long transId) throws PersonNotFoundException;
}
