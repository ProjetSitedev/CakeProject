package com.example.site_vitrine.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity ( name "_testimony")
@Setter
public class testimonial {

    @Id
    @GeneratedValue
    private UUID id;

    private String author;

    private String content;

    private LocalDateTime CreatedAt = LocalDateTime.now();
}