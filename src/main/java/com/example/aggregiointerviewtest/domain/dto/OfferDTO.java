package com.example.aggregiointerviewtest.domain.dto;


import com.example.aggregiointerviewtest.domain.TimeBlock;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OfferDTO {
    private Long marketId;
    List<TimeBlockDTO> timeBlocks;
    List<Long> parcsIds;
    private LocalDateTime start;
    private LocalDateTime end;
    private double energyQuantity;
    private double minimumPrice;
}
