package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.Testimonial;
import com.example.site_vitrine.repository.TestimonialRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;


@Service
public class TestimonialServiceImpl implements TestimonialService {


    /** 
     * TODO: 
     * 
     *  1- Mettre à jour en fonction des changements sur les entités et les repositories
     *  2- Modifier les retours et les paramètres vers des DTO. Tenez à manipuler le moins possible les entités. 
     * 
     * */

    private final TestimonialRepository testimonialRepository;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @Override
    public List<Testimonial> getAllTestimonial() {
        return testimonialRepository.findAll();
    }

    @Override
    public Testimonial getTestimonialById(UUID id){
        return testimonialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Testimony not found"));
    }

    @Override
    public Testimonial createTestimonial(Testimonial testimonial){
        return testimonialRepository.save(testimonial);
    }

    @Override
    public Testimonial updateTestimonial(UUID id, Testimonial updatedTestimonial){
        Testimonial existingTestimonial = getTestimonialById(id);
        if(existingTestimonial != null){
            existingTestimonial.setAuthor(updatedTestimonial.getAuthor());
            existingTestimonial.setContent(updatedTestimonial.getContent());
            existingTestimonial.setCreatedAt(updatedTestimonial.getCreatedAt());
            return testimonialRepository.save(existingTestimonial);
        }
        // Jamais retourner null. Tojours lever une exception lorsque le schéma normal ne s'est pas déroulé.
        return null;
    }

    @Override
    public boolean deleteTestimonial(UUID id){
        // Pas mal comme solution mais on peut faire plus simple. A revoir
        Testimonial existingTestimonial = getTestimonialById(id);
        if(existingTestimonial != null){
            testimonialRepository.delete(existingTestimonial);
            return true;
        }
        return false;
    }

    @Override
    public Testimonial findTestimonialByAuthor(String testimonialAuthor){
        return testimonialRepository.findByAuthor(testimonialAuthor);
    }

    @Override
    public List<Testimonial> searchTestimonial(String keyword) {
        return List.of();
    }
}
