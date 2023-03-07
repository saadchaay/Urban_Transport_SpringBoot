package com.urban.vehicleservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullVehicle", types = Vehicle.class)
public interface VehicleProjection {
    public Long getId();
    public String getName();
    public String getIdentify();
}
