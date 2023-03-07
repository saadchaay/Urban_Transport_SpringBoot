package com.urban.usersservice.web;

import com.urban.usersservice.dtos.transporter.TransporterInputDto;
import com.urban.usersservice.dtos.transporter.TransporterOutputDto;
import com.urban.usersservice.entities.Transporter;
import com.urban.usersservice.exceptions.IncompleteInfos;
import com.urban.usersservice.exceptions.PersonFieldExistException;
import com.urban.usersservice.exceptions.PersonNotFoundException;
import com.urban.usersservice.models.Vehicle;
import com.urban.usersservice.repos.TransporterRepository;
import com.urban.usersservice.services.restClient.VehicleRestClientService;
import com.urban.usersservice.services.transporter.TransporterServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/transporters")
public class TransporterRestController {
    private TransporterServiceImpl transporterService;

    @GetMapping
    public List<TransporterOutputDto> all(){
        return transporterService.listAll();
    }

    @GetMapping("/{id}")
    public TransporterOutputDto one(@PathVariable Long id) throws PersonNotFoundException {
        return transporterService.searchTransporter(id);
    }

    @PostMapping
    public TransporterOutputDto save(@RequestBody TransporterInputDto transporterDto) throws PersonFieldExistException, IncompleteInfos {
        return transporterService.addTransporter(transporterDto);
    }

}
