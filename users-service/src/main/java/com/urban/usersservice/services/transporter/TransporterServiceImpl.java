package com.urban.usersservice.services.transporter;

import com.urban.usersservice.dtos.transporter.TransporterInputDto;
import com.urban.usersservice.dtos.transporter.TransporterOutputDto;
import com.urban.usersservice.entities.Transporter;
import com.urban.usersservice.exceptions.IncompleteInfos;
import com.urban.usersservice.exceptions.PersonFieldExistException;
import com.urban.usersservice.exceptions.PersonNotFoundException;
import com.urban.usersservice.mappers.TransporterMapper;
import com.urban.usersservice.models.Vehicle;
import com.urban.usersservice.repos.TransporterRepository;
import com.urban.usersservice.services.restClient.VehicleRestClientService;
import com.urban.usersservice.utils.KeycloakUtil;
import com.urban.usersservice.utils.TransporterUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class TransporterServiceImpl implements TransporterService {
    private TransporterRepository repository;
    private TransporterMapper transporterMapper;
    private VehicleRestClientService vehClServ;
    private KeycloakUtil kcUtil;

    @Override
    public List<TransporterOutputDto> listAll() {
        List<Transporter> list = repository.findAll();
        for (Transporter tr : list) {
            Transporter transporter = repository.findById(tr.getId()).orElse(null);
            if (transporter != null) {
                Vehicle vehicle = vehClServ.getVehicle(transporter.getVehicleId());
                tr.setVehicle(vehicle);
            }
        }
        return list.stream().map(transporterMapper::fromTransporterEntity).toList();
    }

    @Override
    public TransporterOutputDto addTransporter(TransporterInputDto transporterDto) throws IncompleteInfos, PersonFieldExistException {
        if(TransporterUtil.checkTransporterFields(transporterDto))
            throw new IncompleteInfos("Missing Fields, Try to enter the empty fields!");

        if(repository.findByEmail(transporterDto.getEmail()) != null)
            throw new PersonFieldExistException("The email is already exists!");

        if(repository.findByIdentity(transporterDto.getIdentity()) != null)
            throw new PersonFieldExistException("The identity is already exists!");

        Vehicle vehicle = vehClServ.addVehicle(transporterDto.getVehicle());
        if(vehicle != null) {
            String transKcId = kcUtil.createKeycloakTransporter(transporterDto);
            if(transKcId != null){
                Transporter transporter = TransporterUtil.setTransportAttributes(transporterDto, null, transKcId);
                kcUtil.setCredentials(transKcId, transporter.getPassword());
                kcUtil.addKeycloakUserRole(transKcId, "TRANSPORTER");
                transporter.setVehicleId(vehicle.getId());
                transporter.setVehicle(vehicle);
                return transporterMapper.fromTransporterEntity(repository.save(transporter));
            }
        }
        return null;
    }

    @Override
    public TransporterOutputDto updateTransporter(Long transId, TransporterInputDto transporterDto) throws IncompleteInfos, PersonFieldExistException, PersonNotFoundException {
        if (TransporterUtil.checkTransporterFields(transporterDto))
            throw new IncompleteInfos("Missing Fields!!!!!");

        Transporter oldTr = repository.findById(transId).orElse(null);

        if(oldTr == null)
            throw new PersonNotFoundException("Transporter not Found");

        Transporter transporter = TransporterUtil.setTransportAttributes(transporterDto, transId, null);
        Vehicle vehicle = vehClServ.updateVehicle(
                oldTr.getVehicleId(),
                transporter.getVehicle());

        if(vehicle != null){
            System.out.println("-------------- vehicle: "+vehicle);
            transporter.setVehicleId(vehicle.getId());
            transporter.setVehicle(vehicle);

            if(!Objects.equals(oldTr.getPassword(), transporter.getPassword()) ||
                    !Objects.equals(oldTr.getEmail(), transporter.getEmail())){
                System.out.println("Insert different login info....");
//            update user keycloak info like password ......
            }
        }

        return transporterMapper.fromTransporterEntity(repository.save(transporter));
    }

    @Override
    public TransporterOutputDto searchTransporter(Long transId) throws PersonNotFoundException {
        Transporter transporter = repository.findById(transId).orElseThrow(() -> new PersonNotFoundException("Transporter"));;
        Vehicle vehicle = vehClServ.getVehicle(transporter.getVehicleId());
        transporter.setVehicle(vehicle);
        return transporterMapper.fromTransporterEntity(transporter);
    }

    @Override
    public void deleteTransporter(Long transId) throws PersonNotFoundException {
        Transporter transporter = repository.findById(transId).orElse(null);

        if(transporter == null)
            throw new PersonNotFoundException("Transporter  not found");

        kcUtil.deleteKeycloakUser(transporter.getKeycloakId());
        vehClServ.deleteVehicle(transporter.getVehicleId());
        repository.delete(transporter);
    }
}
