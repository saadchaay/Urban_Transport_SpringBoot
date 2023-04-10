package com.urban.deliveryservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class DeliveryOutputDto {
    private Long id;
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
