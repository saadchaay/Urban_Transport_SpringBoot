package com.urban.deliveryservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class DeliveryInputDto {
    private String depart;
    private String arrival;
    private String departCity;
    private String arrivalCity;
    private Date departDate;
    private Date arrivalDate;
    private Double price;
    private String status;
    private Long transporterId;
}
