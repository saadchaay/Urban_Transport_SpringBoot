package com.urban.usersservice.web;

import com.urban.usersservice.entities.Transporter;
import com.urban.usersservice.models.Vehicle;
import com.urban.usersservice.repos.TransporterRepository;
import com.urban.usersservice.services.restClient.VehicleRestClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PersonsController {

    private TransporterRepository transRepo;

    private VehicleRestClientService vehClServ;

    @GetMapping("/full-transporter/{id}")
    public Transporter getFullTransporter(@PathVariable Long id){
        Transporter transporter = transRepo.findById(id).get();
        Vehicle vehicle = vehClServ.getVehicle(transporter.getVehicleId());
        transporter.setVehicle(vehicle);
        return transporter;
    }

//    @GetMapping("/person-config")
//    public Map<String, Object> getConfig(){
//        return Map.of("Access Token: ", accessToken);
//    }

}
