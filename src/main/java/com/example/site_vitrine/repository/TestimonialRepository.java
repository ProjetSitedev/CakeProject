package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TestimonialRepository extends JpaRepository<Testimonial, UUID> {

    /**
     * Toujours retourner des Optional dans le cas où le retour est unique.
     * Dans le cas où la valeur donnée ne correspond à aucune entrée, l'optional empty permettra d'anticiper d'éventuels NullPointerException.
     */
    Optional<Testimonial> findByAuthor(String author);
}
