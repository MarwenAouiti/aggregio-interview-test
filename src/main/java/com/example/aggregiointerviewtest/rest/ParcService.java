package com.example.aggregiointerviewtest.rest;

import com.example.aggregiointerviewtest.domain.Parc;
import com.example.aggregiointerviewtest.repository.ParcRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ParcService {

    private final ParcRepository parcRepository;

    public ParcService(ParcRepository parcRepository) {
        this.parcRepository = parcRepository;
    }

    public List<Parc> findAll() {
        return parcRepository.findAll();
    }

    public Parc createParc(Parc parc) {
        return parcRepository.save(parc);
    }

    public Set<Parc> findAllByMarket(Long marketId) {
        return parcRepository.findParcsByMarketId(marketId);
    }
}
