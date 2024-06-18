package com.example.site_vitrine.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
public class NewsOrPromotionDTO {
    private UUID id;
    private String title;
    private String content;
    private LocalDate startDate;
    private LocalDate endDate;
}
