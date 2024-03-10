package com.example.aggregiointerviewtest.rest;

import com.example.aggregiointerviewtest.domain.Parc;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/parcs")
public class ParcResource {

    private final ParcService parcService;

    public ParcResource(ParcService parcService) {
        this.parcService = parcService;
    }

    @GetMapping
    public ResponseEntity<List<Parc>> getAll() {
        List<Parc> parcs = parcService.findAll();
        return ResponseEntity.ok(parcs);
    }

    @GetMapping("/byMarket/{marketId}")
    public ResponseEntity<Set<Parc>> getAllByMarket(@PathVariable Long marketId) {
        Set<Parc> parcsByMarket = parcService.findAllByMarket(marketId);
        return ResponseEntity.ok(parcsByMarket);
    }

    @PostMapping
    public ResponseEntity<Parc> createParc(@RequestBody Parc parcDTO) {
        Parc parc = parcService.createParc(parcDTO);
        return ResponseEntity.ok(parc);
    }
}
