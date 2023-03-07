package com.urban.usersservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PersonInputDto {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String picture;
    private String identity;
    private String password;
}
