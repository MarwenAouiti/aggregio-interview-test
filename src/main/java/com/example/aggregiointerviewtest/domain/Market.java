package com.example.aggregiointerviewtest.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MarketType type;

    private String name;
}
