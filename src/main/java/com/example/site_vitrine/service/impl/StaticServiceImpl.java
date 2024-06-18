package com.example.site_vitrine.service.impl;

import com.example.site_vitrine.dto.StaticPageDTO;
import com.example.site_vitrine.entities.StaticPage;
import com.example.site_vitrine.repository.StaticRepository;
import com.example.site_vitrine.service.StaticService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StaticServiceImpl implements StaticService {

    private final StaticRepository staticRepository;

    public StaticServiceImpl(StaticRepository staticRepository) {
        this.staticRepository = staticRepository;
    }

    @Override
    public List<StaticPageDTO> getAllStaticPage() {
        return staticRepository.findAll().stream()
                .map(staticPage -> convertToDTO(Optional.ofNullable(staticPage)))
                .collect(Collectors.toList());
    }

    @Override
    public StaticPageDTO getStaticById(UUID id){
        StaticPage staticPage = staticRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Static not found"));
        return convertToDTO(Optional.ofNullable(staticPage));
    }

    @Override
    public StaticPage updateStatic(UUID id, StaticPage updatedStatic) {
        return null;
    }

    @Override
    public StaticPageDTO updateStatic(UUID id, StaticPageDTO updatedStatic){
        StaticPage existingStatic = staticRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Static not found"));
        existingStatic.setTitle(updatedStatic.getTitle());
        existingStatic.setContent(updatedStatic.getContent());
        return convertToDTO(Optional.of(staticRepository.save(existingStatic)));
    }

    @Override
    public boolean deleteStatic(UUID id){
        StaticPage existingStatic = staticRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Static not found"));
        staticRepository.delete(existingStatic);
        return true;
    }

    @Override
    public List<StaticPageDTO> searchSatics(String keyword){
        return staticRepository.findByTitleContaining(keyword).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StaticPageDTO findStaticByTitle(String title){
        Optional<StaticPage> staticPage = staticRepository.findByTitle(title);
        if (staticPage == null) {
            throw new EntityNotFoundException("Static not found");
        }
        return convertToDTO(staticPage);
    }

    @Override
    public StaticPage createStaticPage(StaticPage staticPage) {
        return null;
    }

    @Override
    public StaticPageDTO createStaticPage(StaticPageDTO staticPageDTO) {
        StaticPage staticPage = new StaticPage();
        staticPage.setTitle(staticPageDTO.getTitle());
        staticPage.setContent(staticPageDTO.getContent());
        return convertToDTO(Optional.of(staticRepository.save(staticPage)));
    }

    private StaticPageDTO convertToDTO(Optional<StaticPage> staticPage) {
        return new StaticPageDTO(staticPage.getId(), staticPage.getTitle(), staticPage.getContent());
    }
}
