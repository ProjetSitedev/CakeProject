package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

<<<<<<< HEAD
public interface TestimonialRepository extends JpaRepository<Testimonial, UUID>;
{
    Testimonial findByAuteur(String author);
}
=======
public interface TestimonialRepository extends JpaRepository<Testimonial, UUID> {
    Testimonial findByAuthor(String author);
}
>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
