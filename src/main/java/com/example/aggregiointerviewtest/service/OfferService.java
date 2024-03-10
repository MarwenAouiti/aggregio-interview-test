package com.example.aggregiointerviewtest.service;

import com.example.aggregiointerviewtest.domain.Market;
import com.example.aggregiointerviewtest.domain.Offer;
import com.example.aggregiointerviewtest.domain.Parc;
import com.example.aggregiointerviewtest.domain.TimeBlock;
import com.example.aggregiointerviewtest.domain.dto.OfferDTO;
import com.example.aggregiointerviewtest.repository.MarketRepository;
import com.example.aggregiointerviewtest.repository.OfferRepository;
import com.example.aggregiointerviewtest.repository.ParcRepository;
import com.example.aggregiointerviewtest.repository.TimeBlockRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final MarketRepository marketRepository;

    private final ParcRepository parcRepository;

    private final TimeBlockRepository timeBlockRepository;

    public OfferService(OfferRepository offerRepository, MarketRepository marketRepository, ParcRepository parcRepository, TimeBlockRepository timeBlockRepository) {
        this.offerRepository = offerRepository;
        this.marketRepository = marketRepository;
        this.parcRepository = parcRepository;
        this.timeBlockRepository = timeBlockRepository;
    }


    public List<Offer> findAllByMarket(Long marketId) {
        return offerRepository.findAllByMarketId(marketId);
    }

    @Transactional
    public Offer createOffer(OfferDTO OfferDTO) {
        Market market = marketRepository.findById(OfferDTO.getMarketId())
            .orElseThrow(() -> new IllegalArgumentException("Market not found"));

        Offer Offer = new Offer();
        Offer.setMarket(market);

        Set<Parc> parcs = OfferDTO.getParcsIds().stream()
            .map(id -> parcRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Parc not found")))
            .collect(Collectors.toSet());
        Offer.setParcs(parcs);

        Set<TimeBlock> timeBlocks = OfferDTO.getTimeBlocks().stream()
            .map(dto -> {
                TimeBlock bloc = new TimeBlock();
                bloc.setStartHour(dto.getStartHour());
                bloc.setEndHour(dto.getEndHour());
                bloc.setEnergiQuantity(dto.getEnergiQuantity());
                bloc.setMinimumPrice(dto.getMinimumPrice());
                bloc.setOffer(Offer);
                return timeBlockRepository.save(bloc);
            }).collect(Collectors.toSet());

        return offerRepository.save(Offer);
    }
}
