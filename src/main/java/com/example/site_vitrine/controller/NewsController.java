package com.example.site_vitrine.controller;

import com.example.site_vitrine.dto.NewsOrPromotionDTO;
import com.example.site_vitrine.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    public ResponseEntity<List<NewsOrPromotionDTO>> getAllNewsOrPromotions() {
        List<NewsOrPromotionDTO> newsOrPromotions = newsService.getAllNewsOrPromotion();
        return ResponseEntity.ok(newsOrPromotions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsOrPromotionDTO> getNewsOrPromotionById(@PathVariable UUID id) {
        Optional<NewsOrPromotionDTO> newsOrPromotion = newsService.getNewsOrPromotionById(id);
        return newsOrPromotion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NewsOrPromotionDTO> createNewsOrPromotion(@RequestBody NewsOrPromotionDTO newsOrPromotionDTO) {
        NewsOrPromotionDTO createdNewsOrPromotion = newsService.createNewsOrPromotion(newsOrPromotionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNewsOrPromotion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsOrPromotionDTO> updateNewsOrPromotion(@PathVariable UUID id, @RequestBody NewsOrPromotionDTO updatedNewsOrPromotionDTO) {
        Optional<NewsOrPromotionDTO> updatedNewsOrPromotion = Optional.ofNullable(newsService.updateNewsOrPromotion(id, updatedNewsOrPromotionDTO));
        return updatedNewsOrPromotion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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
    public ResponseEntity<List<NewsOrPromotionDTO>> searchNewsOrPromotion(@RequestParam("keyword") String keyword) {
        List<NewsOrPromotionDTO> newsOrPromotions = newsService.searchNewsOrPromotion(keyword);
        return ResponseEntity.ok(newsOrPromotions);
    }
}
