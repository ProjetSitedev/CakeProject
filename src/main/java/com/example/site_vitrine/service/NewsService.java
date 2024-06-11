package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.NewsOrPromotion;

import java.util.List;
import java.util.UUID;

public interface NewsService {
    List<NewsOrPromotion> getAllNewsOrPromotion();

    NewsOrPromotion getNewsOrPromotionById(UUID id);

    NewsOrPromotion updateNewsOrPromotion(UUID id, NewsOrPromotion updatedNewsOrPromotion);

    boolean deleteNewsOrPromotion(UUID id);

    NewsOrPromotion findNewsOrPromotionByTitle(String title);

    List<NewsOrPromotion> searchNewsOrPromotion(String keyword);

    NewsOrPromotion createNewsOrPromotion(NewsOrPromotion newsOrPromotion);
}
