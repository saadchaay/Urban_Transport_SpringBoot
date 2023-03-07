package com.urban.vehicleservice.repositories;

import com.urban.vehicleservice.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehicleRepos extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.identify=:identify")
    Vehicle findVehicleByIdentify(@Param("identify") String identify);
}
