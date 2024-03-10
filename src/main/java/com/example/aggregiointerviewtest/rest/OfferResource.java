package com.example.aggregiointerviewtest.rest;

import com.example.aggregiointerviewtest.domain.Offer;
import com.example.aggregiointerviewtest.domain.dto.OfferDTO;
import com.example.aggregiointerviewtest.service.OfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferResource {

    private final OfferService offerService;

    public OfferResource(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody OfferDTO offerDTO){
        Offer offer = offerService.createOffer(offerDTO);
        return ResponseEntity.ok(offer);
    }

    @GetMapping("/byMarket/{marketId}")
    public ResponseEntity<List<Offer>> getAllByMarket(@PathVariable Long marketId){
        List<Offer> offersByMarket =  offerService.findAllByMarket(marketId);
        return ResponseEntity.ok(offersByMarket);
    }
}
