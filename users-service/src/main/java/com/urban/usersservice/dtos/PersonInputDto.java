package com.urban.usersservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class PersonInputDto {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String picture;
    private String identity;
    private String password;
}
