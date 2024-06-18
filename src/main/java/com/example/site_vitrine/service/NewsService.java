package com.example.site_vitrine.service;

import com.example.site_vitrine.dto.NewsOrPromotionDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NewsService {
    List<NewsOrPromotionDTO> getAllNewsOrPromotion();

    Optional<NewsOrPromotionDTO> getNewsOrPromotionById(UUID id);

    NewsOrPromotionDTO createNewsOrPromotion(NewsOrPromotionDTO newsOrPromotionDTO);

    NewsOrPromotionDTO updateNewsOrPromotion(UUID id, NewsOrPromotionDTO updatedNewsOrPromotionDTO);

    boolean deleteNewsOrPromotion(UUID id);

    Optional<NewsOrPromotionDTO> findNewsOrPromotionByTitle(String title);

    List<NewsOrPromotionDTO> searchNewsOrPromotion(String keyword);
}
