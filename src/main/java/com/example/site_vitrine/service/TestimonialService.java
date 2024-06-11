package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.Testimonial;
<<<<<<< HEAD
=======

>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
import java.util.List;
import java.util.UUID;

public interface TestimonialService {
    List<Testimonial> getAllTestimonial();

    Testimonial getTestimonialById(UUID id);

    Testimonial createTestimonial(Testimonial testimonial);

    Testimonial updateTestimonial(UUID id, Testimonial updatedTestimonial);

    boolean deleteTestimonial(UUID id);

    Testimonial findTestimonialByAuthor(String testimonialAuthor);

    List<Testimonial> searchTestimonial(String keyword);
}
