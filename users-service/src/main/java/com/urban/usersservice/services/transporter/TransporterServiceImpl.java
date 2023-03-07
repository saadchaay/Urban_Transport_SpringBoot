package com.urban.usersservice.services.transporter;

import com.urban.usersservice.dtos.PersonInputDto;
import com.urban.usersservice.dtos.PersonOutputDto;
import com.urban.usersservice.dtos.transporter.TransporterInputDto;
import com.urban.usersservice.dtos.transporter.TransporterOutputDto;
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
    public List<TransporterOutputDto> listAll() {
        return null;
    }

    @Override
    public TransporterOutputDto addTransporter(TransporterInputDto transporter) throws IncompleteInfos, PersonFieldExistException {
        return null;
    }

    @Override
    public TransporterOutputDto updateTransporter(Long transId, TransporterInputDto transporter) throws IncompleteInfos, PersonFieldExistException, PersonNotFoundException {
        return null;
    }

    @Override
    public TransporterOutputDto searchTransporter(Long transId) throws PersonNotFoundException {
        return null;
    }

    @Override
    public void deleteTransporter(Long transId) throws PersonNotFoundException {

    }
}
