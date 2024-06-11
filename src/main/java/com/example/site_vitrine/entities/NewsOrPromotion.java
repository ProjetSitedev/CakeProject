package com.example.site_vitrine.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "_news")
@Getter @Setter
public class NewsOrPromotion {

    @Id @GeneratedValue

    private UUID id;

    private String title;

    private String content;

    private LocalDate startDate;

    private LocalDate endDate;
}
