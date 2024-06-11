package com.example.site_vitrine.controller;


import com.example.site_vitrine.entities.NewsOrPromotion;
import com.example.site_vitrine.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<NewsOrPromotion>> getAllNewsOrPromotions() {
        List<NewsOrPromotion> newsOrPromotions = newsService.getAllNewsOrPromotion();
        return ResponseEntity.ok(newsOrPromotions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsOrPromotion> getNewsOrPromotionById(@PathVariable UUID id) {
        return ResponseEntity.ok(newsService.getNewsOrPromotionById(id));
    }

    @PostMapping
    public ResponseEntity<NewsOrPromotion> createNewsOrPromotion(@RequestBody NewsOrPromotion newsOrPromotion) {
        NewsOrPromotion createdNewsOrPromotion = newsService.createNewsOrPromotion(newsOrPromotion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNewsOrPromotion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsOrPromotion> updateNewsOrPromotion(@PathVariable UUID id, @RequestBody NewsOrPromotion updatedNewsOrPromotion) {
        NewsOrPromotion newsOrPromotion = newsService.updateNewsOrPromotion(id, updatedNewsOrPromotion);
        if (newsOrPromotion != null) {
            return ResponseEntity.ok(newsOrPromotion);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNewsOrPromotion(@PathVariable UUID id) {
        boolean deleted = newsService.deleteNewsOrPromotion(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<NewsOrPromotion>> searchNewsOrPromotion(@RequestParam("keyword") String keyword) {
        List<NewsOrPromotion> newsOrPromotions = newsService.searchNewsOrPromotion(keyword);
        return ResponseEntity.ok(newsOrPromotions);
    }
}
