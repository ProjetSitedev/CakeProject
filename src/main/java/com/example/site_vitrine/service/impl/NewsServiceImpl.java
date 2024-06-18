package com.example.site_vitrine.service.impl;

import com.example.site_vitrine.dto.NewsOrPromotionDTO;
import com.example.site_vitrine.entities.NewsOrPromotion;
import com.example.site_vitrine.repository.NewsOrPromotionRepository;
import com.example.site_vitrine.service.NewsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsOrPromotionRepository newsOrPromotionRepository;

    public NewsServiceImpl(NewsOrPromotionRepository newsOrPromotionRepository) {
        this.newsOrPromotionRepository = newsOrPromotionRepository;
    }

    @Override
    public List<NewsOrPromotionDTO> getAllNewsOrPromotion() {
        return newsOrPromotionRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NewsOrPromotionDTO> getNewsOrPromotionById(UUID id) {
        return newsOrPromotionRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public NewsOrPromotionDTO createNewsOrPromotion(NewsOrPromotionDTO newsOrPromotionDTO) {
        NewsOrPromotion newsOrPromotion = convertToEntity(newsOrPromotionDTO);
        return convertToDTO(newsOrPromotionRepository.save(newsOrPromotion));
    }

    @Override
    public NewsOrPromotionDTO updateNewsOrPromotion(UUID id, NewsOrPromotionDTO updatedNewsOrPromotionDTO) {
        NewsOrPromotion existingNewsOrPromotion = newsOrPromotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News not found"));
        existingNewsOrPromotion.setTitle(updatedNewsOrPromotionDTO.getTitle());
        existingNewsOrPromotion.setContent(updatedNewsOrPromotionDTO.getContent());
        existingNewsOrPromotion.setStartDate(updatedNewsOrPromotionDTO.getStartDate());
        existingNewsOrPromotion.setEndDate(updatedNewsOrPromotionDTO.getEndDate());
        return convertToDTO(newsOrPromotionRepository.save(existingNewsOrPromotion));
    }

    @Override
    public boolean deleteNewsOrPromotion(UUID id) {
        NewsOrPromotion existingNewsOrPromotion = newsOrPromotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News not found"));
        newsOrPromotionRepository.delete(existingNewsOrPromotion);
        return true;
    }

    @Override
    public Optional<NewsOrPromotionDTO> findNewsOrPromotionByTitle(String title) {
        return newsOrPromotionRepository.findByTitle(title)
                .map(this::convertToDTO);
    }

    @Override
    public List<NewsOrPromotionDTO> searchNewsOrPromotion(String keyword) {
        // Implémentation de la recherche par mot-clé
        return List.of(); // Remplacer par une implémentation appropriée
    }

    private NewsOrPromotionDTO convertToDTO(NewsOrPromotion newsOrPromotion) {
        NewsOrPromotionDTO dto = new NewsOrPromotionDTO();
        dto.setId(newsOrPromotion.getId());
        dto.setTitle(newsOrPromotion.getTitle());
        dto.setContent(newsOrPromotion.getContent());
        dto.setStartDate(newsOrPromotion.getStartDate());
        dto.setEndDate(newsOrPromotion.getEndDate());
        return dto;
    }

    private NewsOrPromotion convertToEntity(NewsOrPromotionDTO dto) {
        NewsOrPromotion newsOrPromotion = new NewsOrPromotion();
        newsOrPromotion.setId(dto.getId());
        newsOrPromotion.setTitle(dto.getTitle());
        newsOrPromotion.setContent(dto.getContent());
        newsOrPromotion.setStartDate(dto.getStartDate());
        newsOrPromotion.setEndDate(dto.getEndDate());
        return newsOrPromotion;
    }
}
