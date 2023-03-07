package com.urban.usersservice.entities.projections;

import com.urban.usersservice.entities.Transporter;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "full-transporter", types = Transporter.class)

public interface TransporterProjection {
    Long getId();
    String getName();
    String getEmail();
    String getPhone();
    String getAddress();
    String getPicture();
    String getIdentity();
    String getPassword();
    Long getVehicleId();
}
