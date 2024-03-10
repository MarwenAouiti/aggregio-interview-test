package com.example.aggregiointerviewtest.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeBlockDTO {
    private LocalDateTime startHour;
    private LocalDateTime endHour;
    private double energiQuantity;
    private double minimumPrice;
}
