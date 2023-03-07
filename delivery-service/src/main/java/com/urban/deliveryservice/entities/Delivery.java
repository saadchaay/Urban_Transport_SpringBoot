package com.urban.deliveryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departure;

    private String destination;

    private Double price;

//    private Date depart_date;
//    private Date arrival_date;

    private String status;

}
