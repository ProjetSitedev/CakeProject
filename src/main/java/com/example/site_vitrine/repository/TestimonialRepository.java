package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestimonialRepository extends JpaRepository<Testimonial, UUID> {
    Testimonial findByAuthor(String author);
}
