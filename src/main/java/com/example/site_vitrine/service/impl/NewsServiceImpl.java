package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.NewsOrPromotion;
import com.example.site_vitrine.repository.NewsOrPromotionRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public class NewsServiceImpl implements NewsService {

     /** 
     * TODO: 
     * 
     *  1- Mettre à jour en fonction des changements sur les entités et les repositories
     *  2- Modifier les retours et les paramètres vers des DTO. Tenez à manipuler le moins possible les entités. 
     * 
     * */

    private final NewsOrPromotionRepository newsOrpromotionRepository;

    public NewsServiceImpl(NewsOrPromotionRepository newsOrPromotionRepository) {
        this.newsOrpromotionRepository = newsOrPromotionRepository;
    }

    @Override
    public List<NewsOrPromotion> getAllNewsOrPromotion()  {
        return newsOrpromotionRepository.findAll();
    }


    @Override
    public NewsOrPromotion getNewsOrPromotionById(UUID id){
        return newsOrpromotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News not found"));
    }

    @Override
    public NewsOrPromotion createNewsOrPromotion (NewsOrPromotion newsOrPromotion){
        return newsOrpromotionRepository.save(newsOrPromotion);
    }

    @Override
    public NewsOrPromotion updateNewsOrPromotion(UUID id, NewsOrPromotion updatedNewsOrPromotion){
        NewsOrPromotion existingNewsOrPromotion = getNewsOrPromotionById(id);
        if( existingNewsOrPromotion!= null){
            existingNewsOrPromotion.setTitle(updatedNewsOrPromotion.getTitle());
            existingNewsOrPromotion.setContent(updatedNewsOrPromotion.getContent());
            existingNewsOrPromotion.setStartDate(updatedNewsOrPromotion.getStartDate());
            existingNewsOrPromotion.setEndDate(updatedNewsOrPromotion.getEndDate());
            return newsOrpromotionRepository.save(existingNewsOrPromotion);
        }
        return null;
    }

    @Override
    public boolean deleteNewsOrPromotion(UUID id){
        NewsOrPromotion existingNewsOrPromotion = getNewsOrPromotionById(id);
        if(existingNewsOrPromotion != null){
            newsOrpromotionRepository.delete(existingNewsOrPromotion);
            return true;
        }
        return false;
    }

    @Override
    public NewsOrPromotion findNewsOrPromotionByTitle(String title){
        return newsOrpromotionRepository.findByTitle(title);
    }

    @Override
    public List<NewsOrPromotion> searchNewsOrPromotion(String keyword) {
        return List.of();
    }
}
