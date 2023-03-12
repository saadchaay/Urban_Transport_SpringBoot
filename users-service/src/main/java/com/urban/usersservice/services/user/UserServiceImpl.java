package com.urban.usersservice.services.user;

import com.urban.usersservice.dtos.users.UserInputDto;
import com.urban.usersservice.dtos.users.UserOutputDto;
import com.urban.usersservice.entities.Transporter;
import com.urban.usersservice.entities.User;
import com.urban.usersservice.exceptions.IncompleteInfos;
import com.urban.usersservice.exceptions.PersonFieldExistException;
import com.urban.usersservice.exceptions.PersonNotFoundException;
import com.urban.usersservice.mappers.UserMapper;
import com.urban.usersservice.repos.UserRepository;
import com.urban.usersservice.utils.KeycloakUtil;
import com.urban.usersservice.utils.TransporterUtil;
import com.urban.usersservice.utils.UserUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository repository;
    private UserMapper userMapper;
    private KeycloakUtil kcUtil;

    @Override
    public List<UserOutputDto> listAll() {
        return repository.findAll()
                .stream().map(userMapper::fromUserEntity).toList();
    }

    @Override
    public UserOutputDto addUser(UserInputDto userDto) throws IncompleteInfos, PersonFieldExistException {
        if(UserUtil.checkUserFields(userDto))
            throw new IncompleteInfos("Missing Fields, Try to enter the empty fields!");

        if(repository.findByEmail(userDto.getEmail()) != null)
            throw new PersonFieldExistException("The email is already exists!");

        if(repository.findByIdentity(userDto.getIdentity()) != null)
            throw new PersonFieldExistException("The identity is already exists!");

        User user = UserUtil.setUserAttributes(userDto, null);
        kcUtil.createKeycloakUserWithRole(userDto, user.getPassword());

        return userMapper.fromUserEntity(repository.save(user));
    }

    @Override
    public UserOutputDto updateUser(Long userId, UserInputDto userDto) throws IncompleteInfos, PersonFieldExistException, PersonNotFoundException {
        if (UserUtil.checkUserFields(userDto))
            throw new IncompleteInfos("Missing Fields!!!!!");

        repository.findById(userId)
                .orElseThrow(() -> new PersonNotFoundException("User not Found"));

        User user = UserUtil.setUserAttributes(userDto, userId);
        return userMapper.fromUserEntity(repository.save(user));
    }

    @Override
    public UserOutputDto searchUser(Long userId) throws PersonNotFoundException {
        User user = repository.findById(userId).orElseThrow(() -> new PersonNotFoundException("User"));
        return userMapper.fromUserEntity(user);
    }

    @Override
    public void deleteUser(Long userId) throws PersonNotFoundException {
        User user = repository.findById(userId).orElse(null);

        if(user == null)
            throw new PersonNotFoundException("User not found");

        repository.delete(user);
    }
}
