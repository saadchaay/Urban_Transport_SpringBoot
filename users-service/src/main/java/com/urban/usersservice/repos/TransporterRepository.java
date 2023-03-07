package com.urban.usersservice.repos;

import com.urban.usersservice.entities.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TransporterRepository extends JpaRepository<Transporter, Long> {

    Transporter findByEmail(String email);
    Transporter findByIdentity(String identity);


}
