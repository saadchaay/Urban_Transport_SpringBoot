package com.urban.usersservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.urban.usersservice.entities.person.PersonData;
import com.urban.usersservice.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class Transporter extends PersonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long vehicleId;
    @Transient
    private Vehicle vehicle;
}
