package com.urban.usersservice.services.user;

import com.urban.usersservice.dtos.users.UserInputDto;
import com.urban.usersservice.dtos.users.UserOutputDto;
import com.urban.usersservice.exceptions.IncompleteInfos;
import com.urban.usersservice.exceptions.PersonFieldExistException;
import com.urban.usersservice.exceptions.PersonNotFoundException;
import com.urban.usersservice.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository repository;

    @Override
    public List<UserOutputDto> listAll() {
        return null;
    }

    @Override
    public UserOutputDto addUser(UserInputDto user) throws IncompleteInfos, PersonFieldExistException {
        return null;
    }

    @Override
    public UserOutputDto updateUser(Long userId, UserInputDto user) throws IncompleteInfos, PersonFieldExistException, PersonNotFoundException {
        return null;
    }

    @Override
    public UserOutputDto searchUser(Long userId) throws PersonNotFoundException {
        return null;
    }

    @Override
    public void deleteUser(Long userId) throws PersonNotFoundException {

    }
}
