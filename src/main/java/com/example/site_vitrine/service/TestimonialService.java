package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.Testimonial;

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
