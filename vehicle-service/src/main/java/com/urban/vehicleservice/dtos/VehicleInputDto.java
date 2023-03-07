package com.urban.vehicleservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class VehicleInputDto {
    private String name;
    private String identify; // Matricule
}
