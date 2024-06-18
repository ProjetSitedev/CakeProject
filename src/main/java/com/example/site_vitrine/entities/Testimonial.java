package com.example.site_vitrine.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * Objectif: Garder un ordre pour les réponses à des commentaires qui en soit sont des commentaires.
     */
    private short sortOrder;

    /**
     * Auteur du commentaire. Si la personne doit être connectée, ajuster pour que ce soit un lien avec un utilisateur.
     */
    private String author;

    /**
     * Contenu du témoignage.
     */
    private String content;

    /**
     * Date de création du témoignage.
     */
    private LocalDateTime createdAt = LocalDateTime.now();
}
