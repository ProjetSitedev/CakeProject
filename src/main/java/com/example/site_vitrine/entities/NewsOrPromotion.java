package com.example.site_vitrine.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class NewsOrPromotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String contenu;

    private Date datePublication;

    // Getters et setters
}

@Entity
public class newsOrPromotionPromotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private double prixReductiion;

    private Date dateDebut;

    private Date dateFin;

    // Getters et setters
}
