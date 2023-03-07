package com.urban.usersservice.entities;

import com.urban.usersservice.entities.person.PersonData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class User extends PersonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

}
