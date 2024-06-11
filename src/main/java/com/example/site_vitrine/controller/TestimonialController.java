package com.example.site_vitrine.controller;


import com.example.site_vitrine.entities.Testimonial;
import com.example.site_vitrine.service.TestimonialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/testimony")
public class TestimonialController {

    private final TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService) {
        this.testimonialService = testimonialService;
    }

    @GetMapping
    public ResponseEntity<List<Testimonial>> getAllTestimonial() {
        List<Testimonial> testimonials = testimonialService.getAllTestimonial();
        return ResponseEntity.ok(testimonials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Testimonial> getTestimonialById(@PathVariable UUID id) {
        return ResponseEntity.ok(testimonialService.getTestimonialById(id));
    }

    @PostMapping
    public ResponseEntity<Testimonial> createTestimonial(@RequestBody Testimonial testimonial) {
        Testimonial createdTestimonial = testimonialService.createTestimonial(testimonial);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTestimonial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Testimonial> updateTestimonial(@PathVariable UUID id, @RequestBody Testimonial updatedTestimonial) {
        Testimonial testimonial = testimonialService.updateTestimonial(id, updatedTestimonial);
        if (testimonial != null) {
            return ResponseEntity.ok(testimonial);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonial(@PathVariable UUID id) {
        boolean deleted = testimonialService.deleteTestimonial(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Testimonial>> searchTestimonial(@RequestParam("keyword") String keyword) {
        List<Testimonial> testimonials = testimonialService.searchTestimonial(keyword);
        return ResponseEntity.ok(testimonials);
    }
}
