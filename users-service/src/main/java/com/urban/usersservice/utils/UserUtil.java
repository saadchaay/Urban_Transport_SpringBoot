package com.urban.usersservice.utils;

import com.urban.usersservice.dtos.users.UserInputDto;
import com.urban.usersservice.entities.User;

public class UserUtil {

    public static User setUserAttributes(UserInputDto transDto, Long userId){
        User user = new User();
        if(userId != null)
            user.setId(userId);
        user.setName(transDto.getName());
        user.setAddress(transDto.getAddress());
        user.setEmail(transDto.getEmail());
        user.setPassword(transDto.getPassword());
        user.setIdentity(transDto.getIdentity());
        user.setPicture(transDto.getPicture());
        user.setPhone(transDto.getPhone());
        return user;
    }

    public static boolean checkUserFields(UserInputDto userDto){ // from VehicleInputDto
        return (userDto.getName() == null || userDto.getName().isEmpty()
                || userDto.getEmail() == null || userDto.getEmail().isEmpty()
                || userDto.getPhone() == null || userDto.getPhone().isEmpty()
                || userDto.getAddress() == null || userDto.getAddress().isEmpty()
                || userDto.getPicture() == null || userDto.getPicture().isEmpty()
                || userDto.getIdentity() == null || userDto.getIdentity().isEmpty()
                || userDto.getPassword() == null || userDto.getPassword().isEmpty()
        );
    }

}
