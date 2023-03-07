package com.urban.usersservice.web;

import com.urban.usersservice.dtos.transporter.TransporterOutputDto;
import com.urban.usersservice.dtos.users.UserInputDto;
import com.urban.usersservice.dtos.users.UserOutputDto;
import com.urban.usersservice.entities.Transporter;
import com.urban.usersservice.exceptions.IncompleteInfos;
import com.urban.usersservice.exceptions.PersonFieldExistException;
import com.urban.usersservice.exceptions.PersonNotFoundException;
import com.urban.usersservice.models.Vehicle;
import com.urban.usersservice.repos.TransporterRepository;
import com.urban.usersservice.services.restClient.VehicleRestClientService;
import com.urban.usersservice.services.transporter.TransporterServiceImpl;
import com.urban.usersservice.services.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private UserServiceImpl userService;

    @GetMapping
    public List<UserOutputDto> all(){
        return userService.listAll();
    }

    @GetMapping("/{id}")
    public UserOutputDto one(@PathVariable Long id) throws PersonNotFoundException {
        return userService.searchUser(id);
    }

    @PostMapping
    public UserOutputDto save(@RequestBody UserInputDto userDto) throws PersonFieldExistException, IncompleteInfos {
        return userService.addUser(userDto);
    }


}
