package com.example.site_vitrine.controller;

import com.example.site_vitrine.dto.TestimonialDTO;
import com.example.site_vitrine.service.TestimonialService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/testimonials")
public class TestimonialController {

    private final TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService) {
        this.testimonialService = testimonialService;
    }

    @GetMapping
    public ResponseEntity<List<TestimonialDTO>> getAllTestimonials() {
        List<TestimonialDTO> testimonials = testimonialService.getAllTestimonials();
        return ResponseEntity.ok(testimonials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestimonialDTO> getTestimonialById(@PathVariable UUID id) {
        Optional<TestimonialDTO> testimonialDTO = testimonialService.getTestimonialById(id);
        return testimonialDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TestimonialDTO> createTestimonial(@RequestBody TestimonialDTO testimonialDTO) {
        TestimonialDTO createdTestimonial = testimonialService.createTestimonial(testimonialDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTestimonial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestimonialDTO> updateTestimonial(@PathVariable UUID id, @RequestBody TestimonialDTO updatedTestimonialDTO) {
        try {
            TestimonialDTO updatedTestimonial = testimonialService.updateTestimonial(id, updatedTestimonialDTO);
            return ResponseEntity.ok(updatedTestimonial);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonial(@PathVariable UUID id) {
        try {
            boolean deleted = testimonialService.deleteTestimonial(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<TestimonialDTO>> searchTestimonials(@RequestParam("keyword") String keyword) {
        List<TestimonialDTO> testimonials = testimonialService.searchTestimonials(keyword);
        return ResponseEntity.ok(testimonials);
    }
}
