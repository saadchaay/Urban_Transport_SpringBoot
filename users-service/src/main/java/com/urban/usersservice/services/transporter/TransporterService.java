package com.urban.usersservice.services.transporter;

import com.urban.usersservice.dtos.PersonInputDto;
import com.urban.usersservice.dtos.PersonOutputDto;
import com.urban.usersservice.exceptions.IncompleteInfos;
import com.urban.usersservice.exceptions.PersonFieldExistException;
import com.urban.usersservice.exceptions.PersonNotFoundException;

import java.util.List;

public interface TransporterService {
    List<PersonOutputDto> listAll();
    PersonOutputDto addTransporter(PersonInputDto transporter) throws IncompleteInfos, PersonFieldExistException;
    PersonOutputDto updateTransporter(Long transId, PersonInputDto transporter) throws IncompleteInfos, PersonFieldExistException, PersonNotFoundException;
    PersonOutputDto searchTransporter(Long transId) throws PersonNotFoundException;
    void deleteTransporter(Long transId) throws PersonNotFoundException;
}
