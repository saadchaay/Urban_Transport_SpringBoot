package com.urban.usersservice.entities.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PersonData {

    private String keycloakId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String picture;
    private String identity;
    private String password;

}
