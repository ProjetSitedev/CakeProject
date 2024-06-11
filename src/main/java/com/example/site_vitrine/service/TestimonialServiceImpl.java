package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.Testimonial;
import com.example.site_vitrine.repository.TestimonialRepository;
import jakarta.persistence.EntityNotFoundException;
<<<<<<< HEAD
=======

>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
import java.util.List;
import java.util.UUID;

public class TestimonialServiceImpl implements TestimonialService {
<<<<<<< HEAD
=======

>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
    private final TestimonialRepository testimonialRepository;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @Override
    public List<Testimonial> getAllTestimonial() {
        return testimonialRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public Testimonial getTestimonialById(UUID id) {
=======
    public Testimonial getTestimonialById(UUID id){
>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
        return testimonialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Testimony not found"));
    }

    @Override
<<<<<<< HEAD
    public Testimonial createTestimonial(Testimonial testimonial) {
=======
    public Testimonial createTestimonial(Testimonial testimonial){
>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
        return testimonialRepository.save(testimonial);
    }

    @Override
<<<<<<< HEAD
    public Testimonial updateTestimonial(UUID id, Testimonial updatedTestimonial) {
        Testimonial existingTestimonial = getTestimonialById(id);
        if (existingTestimonial != null) {
=======
    public Testimonial updateTestimonial(UUID id, Testimonial updatedTestimonial){
        Testimonial existingTestimonial = getTestimonialById(id);
        if(existingTestimonial != null){
>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
            existingTestimonial.setAuthor(updatedTestimonial.getAuthor());
            existingTestimonial.setContent(updatedTestimonial.getContent());
            existingTestimonial.setCreatedAt(updatedTestimonial.getCreatedAt());
            return testimonialRepository.save(existingTestimonial);
        }
        return null;
    }

    @Override
<<<<<<< HEAD
    public boolean deleteTestimonial(UUID id) {
        Testimonial existingTestimonial = getTestimonialById(id);
        if (existingTestimonial != null) {
=======
    public boolean deleteTestimonial(UUID id){
        Testimonial existingTestimonial = getTestimonialById(id);
        if(existingTestimonial != null){
>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
            testimonialRepository.delete(existingTestimonial);
            return true;
        }
        return false;
    }

    @Override
<<<<<<< HEAD
    public Testimonial findTestimonialByAuthor(String testimonialAuthor) {
=======
    public Testimonial findTestimonialByAuthor(String testimonialAuthor){
>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
        return testimonialRepository.findByAuthor(testimonialAuthor);
    }

    @Override
    public List<Testimonial> searchTestimonial(String keyword) {
        return List.of();
    }
}
