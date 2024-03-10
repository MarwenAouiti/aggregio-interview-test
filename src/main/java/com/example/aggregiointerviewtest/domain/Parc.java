package com.example.aggregiointerviewtest.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Parc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "parcs")
    private Set<Offer> offres;

    private double productionCapacity;

    @Enumerated(EnumType.STRING)
    private ParcType type;
}
