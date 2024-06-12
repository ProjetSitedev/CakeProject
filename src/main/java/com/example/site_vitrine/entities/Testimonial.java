package com.example.site_vitrine.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "_testimony")
@Getter @Setter
public class Testimonial {

    @Id @GeneratedValue
    private UUID id;

    /**
     * TODO: Prendre en compte cette propriété dans le service
     * 
     * Objectif: Garder un ordre pour les réponses à des commentaires qui en soit sont des commentaires. 
     *  */
    private short order;

    // Si pour commenter la personne doit etre connecté, ajuster pour que ce soit un lien avec un utilisateur
    private String author;

    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();
}
