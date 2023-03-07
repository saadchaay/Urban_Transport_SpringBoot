package com.urban.usersservice.services.user;

import com.urban.usersservice.dtos.users.UserInputDto;
import com.urban.usersservice.dtos.users.UserOutputDto;
import com.urban.usersservice.exceptions.IncompleteInfos;
import com.urban.usersservice.exceptions.PersonFieldExistException;
import com.urban.usersservice.exceptions.PersonNotFoundException;

import java.util.List;

public interface UserService {
    List<UserOutputDto> listAll();
    UserOutputDto addUser(UserInputDto user) throws IncompleteInfos, PersonFieldExistException;
    UserOutputDto updateUser(Long userId, UserInputDto user) throws IncompleteInfos, PersonFieldExistException, PersonNotFoundException;
    UserOutputDto searchUser(Long userId) throws PersonNotFoundException;
    void deleteUser(Long userId) throws PersonNotFoundException;
}
