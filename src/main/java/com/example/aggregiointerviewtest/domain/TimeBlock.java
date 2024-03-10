package com.example.aggregiointerviewtest.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class TimeBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Offer offer;

    private LocalDateTime startHour;
    private LocalDateTime endHour;
    private double energiQuantity;
    private double minimumPrice;
}
