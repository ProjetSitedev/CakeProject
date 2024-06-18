package com.example.site_vitrine.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity (name = "_staticpage")
@Getter @Setter
public class StaticPage {

    @Id @GeneratedValue
    private UUID id;

    private String title;

    private String content;
}
