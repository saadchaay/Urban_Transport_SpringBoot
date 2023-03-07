package com.urban.usersservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PersonOutputDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String picture;
    private String identity;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
