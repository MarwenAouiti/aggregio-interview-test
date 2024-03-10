package com.example.aggregiointerviewtest.repository;

import com.example.aggregiointerviewtest.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAllByMarketId(Long marketId);
}
