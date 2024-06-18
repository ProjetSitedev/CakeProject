package com.example.site_vitrine.service.impl;

import com.example.site_vitrine.dto.TestimonialDTO;
import com.example.site_vitrine.entities.Testimonial;
import com.example.site_vitrine.repository.TestimonialRepository;
import com.example.site_vitrine.service.TestimonialService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @Override
    public List<TestimonialDTO> getAllTestimonials() {
        return testimonialRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TestimonialDTO> getTestimonialById(UUID id) {
        return testimonialRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public TestimonialDTO createTestimonial(TestimonialDTO testimonialDTO) {
        Testimonial testimonial = convertToEntity(testimonialDTO);
        return convertToDTO(testimonialRepository.save(testimonial));
    }

    @Override
    public TestimonialDTO updateTestimonial(UUID id, TestimonialDTO updatedTestimonialDTO) {
        Testimonial existingTestimonial = testimonialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Testimonial not found"));
        existingTestimonial.setAuthor(updatedTestimonialDTO.getAuthor());
        existingTestimonial.setContent(updatedTestimonialDTO.getContent());
        existingTestimonial.setSortOrder(updatedTestimonialDTO.getSortOrder());
        existingTestimonial.setCreatedAt(updatedTestimonialDTO.getCreatedAt());
        return convertToDTO(testimonialRepository.save(existingTestimonial));
    }

    @Override
    public boolean deleteTestimonial(UUID id) {
        if (testimonialRepository.existsById(id)) {
            testimonialRepository.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Testimonial not found");
        }
    }

    @Override
    public Optional<TestimonialDTO> findTestimonialByAuthor(String author) {
        return testimonialRepository.findByAuthor(author)
                .map(this::convertToDTO);
    }

    @Override
    public List<TestimonialDTO> searchTestimonials(String keyword) {
        return List.of();
    }

    @Override
    public List<TestimonialDTO> searchTestimonial(String keyword) {
        // Implement a search method in the repository and use it here
        return List.of();
    }

    private TestimonialDTO convertToDTO(Testimonial testimonial) {
        TestimonialDTO dto = new TestimonialDTO();
        dto.setId(testimonial.getId());
        dto.setAuthor(testimonial.getAuthor());
        dto.setContent(testimonial.getContent());
        dto.setSortOrder(testimonial.getSortOrder());
        dto.setCreatedAt(testimonial.getCreatedAt());
        return dto;
    }

    private Testimonial convertToEntity(TestimonialDTO dto) {
        Testimonial testimonial = new Testimonial();
        testimonial.setId(dto.getId());
        testimonial.setAuthor(dto.getAuthor());
        testimonial.setContent(dto.getContent());
        testimonial.setSortOrder(dto.getSortOrder());
        testimonial.setCreatedAt(dto.getCreatedAt());
        return testimonial;
    }
}
