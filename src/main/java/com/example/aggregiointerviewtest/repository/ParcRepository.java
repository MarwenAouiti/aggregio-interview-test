package com.example.aggregiointerviewtest.repository;

import com.example.aggregiointerviewtest.domain.Parc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ParcRepository extends JpaRepository<Parc, Long> {
    @Query("SELECT p FROM Parc p JOIN p.offres o WHERE o.market.id = :marketId")
    Set<Parc> findParcsByMarketId(Long marketId);
}
