package com.example.aggregiointerviewtest.repository;

import com.example.aggregiointerviewtest.domain.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Long> {
}
