package com.example.aggregiointerviewtest.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Market market;

    @ManyToMany
    @JoinTable(
        name = "offer_parc",
        joinColumns = @JoinColumn(name = "offer_id"),
        inverseJoinColumns = @JoinColumn(name = "parc_id"))
    private Set<Parc> parcs;

    private LocalDateTime start;
    private LocalDateTime end;
    private double energyQuantity;
    private double minimumPrice;
}
