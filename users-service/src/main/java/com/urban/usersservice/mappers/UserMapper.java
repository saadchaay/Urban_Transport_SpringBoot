package com.urban.usersservice.mappers;

import com.urban.usersservice.dtos.transporter.TransporterOutputDto;
import com.urban.usersservice.dtos.users.UserOutputDto;
import com.urban.usersservice.entities.Transporter;
import com.urban.usersservice.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserOutputDto fromUserEntity(User user){
        UserOutputDto userDto = new UserOutputDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
