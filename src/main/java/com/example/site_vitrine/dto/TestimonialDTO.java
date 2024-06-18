package com.example.site_vitrine.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
public class TestimonialDTO {
    private UUID id;
    private String author;
    private String content;
    private short sortOrder;
    private LocalDateTime createdAt;
}
