package com.example.site_vitrine.service;

import com.example.site_vitrine.dto.TestimonialDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TestimonialService {
    List<TestimonialDTO> getAllTestimonials();

    Optional<TestimonialDTO> getTestimonialById(UUID id);

    TestimonialDTO createTestimonial(TestimonialDTO testimonialDTO);

    TestimonialDTO updateTestimonial(UUID id, TestimonialDTO updatedTestimonialDTO);

    boolean deleteTestimonial(UUID id);

    Optional<TestimonialDTO> findTestimonialByAuthor(String testimonialAuthor);

    List<TestimonialDTO> searchTestimonials(String keyword);

    List<TestimonialDTO> searchTestimonial(String keyword);
}
