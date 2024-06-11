package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.StaticPage;
import com.example.site_vitrine.repository.StaticRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public class StaticServiceImpl implements StaticService {

    private final StaticRepository staticRepository;

    public StaticServiceImpl(StaticRepository staticRepository) {
        this.staticRepository = staticRepository;
    }

    @Override
    public List<StaticPage> getAllStaticPage(){
        return staticRepository.findAll();
    }

    @Override
    public StaticPage getStaticById(UUID id){
        return staticRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Static not found"));
    }

    @Override
    public StaticPage updateStatic(UUID id, StaticPage updatedStatic){
        StaticPage existingStatic = getStaticById(id);
        if(existingStatic != null){
            existingStatic.setTitle(updatedStatic.getTitle());
            existingStatic.setContent(updatedStatic.getContent());
            return staticRepository.save(existingStatic);
        }
        return null;
    }

    @Override
    public boolean deleteStatic(UUID id){
        StaticPage existingStatic = getStaticById(id);
        if(existingStatic != null){
            staticRepository.delete(existingStatic);
            return true;
        }
        return false;
    }

    @Override
    public List<StaticPage> searchSatics(String keyword){
        return List.of();
    }

    @Override
    public StaticPage findStaticByTitle(String title){
        return staticRepository.findByTitle(title);
    }

    @Override
    public StaticPage createStaticPage(StaticPage staticPage) {
        return  staticRepository.save(staticPage);
    }
}
