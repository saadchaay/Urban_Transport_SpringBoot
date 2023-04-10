package com.urban.deliveryservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Vehicle {
    private Long id;
    private String name;
    private String identify;
}
