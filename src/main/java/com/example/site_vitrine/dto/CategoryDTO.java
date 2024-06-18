package com.example.site_vitrine.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class CategoryDTO {
    private UUID id;
    private String name;
    private String description;

}