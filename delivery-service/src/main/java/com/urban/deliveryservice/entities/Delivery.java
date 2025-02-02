package com.urban.deliveryservice.entities;

import com.urban.deliveryservice.models.Transporter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Transient
    private Transporter transporter;

}
