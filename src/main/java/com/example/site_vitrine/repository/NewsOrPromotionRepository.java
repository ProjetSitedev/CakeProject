package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.NewsOrPromotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsOrPromotionRepository extends JpaRepository<NewsOrPromotion, UUID> {
    NewsOrPromotion findByTitle(String title);
}
