package com.urban.usersservice.services.transporter;

import com.urban.usersservice.dtos.PersonInputDto;
import com.urban.usersservice.dtos.PersonOutputDto;
import com.urban.usersservice.exceptions.IncompleteInfos;
import com.urban.usersservice.exceptions.PersonFieldExistException;
import com.urban.usersservice.exceptions.PersonNotFoundException;
import com.urban.usersservice.repos.TransporterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TransporterServiceImpl implements TransporterService {
    private TransporterRepository repository;

    @Override
    public List<PersonOutputDto> listAll() {
        List<PersonOutputDto> personDto;
//        personDto = repository.findAll();
        return null;
    }

    @Override
    public PersonOutputDto addTransporter(PersonInputDto transporter) throws IncompleteInfos, PersonFieldExistException {
        return null;
    }

    @Override
    public PersonOutputDto updateTransporter(Long transId, PersonInputDto transporter) throws IncompleteInfos, PersonFieldExistException, PersonNotFoundException {
        return null;
    }

    @Override
    public PersonOutputDto searchTransporter(Long transId) throws PersonNotFoundException {
        return null;
    }

    @Override
    public void deleteTransporter(Long transId) throws PersonNotFoundException {

    }
}
