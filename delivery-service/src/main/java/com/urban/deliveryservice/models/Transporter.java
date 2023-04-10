package com.urban.deliveryservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Transporter {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String picture;
    private String identity;
    private String password;
    private Long vehicleId;
    private Vehicle vehicle;
}
