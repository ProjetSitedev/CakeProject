package com.example.site_vitrine.service;

import com.example.site_vitrine.dto.NewsOrPromotionDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NewsOrPromotionService extends JpaRepository<NewsOrPromotion, Long> {
}
@Service
public class NewsOrPromotionServiceImpl implements NewsOrPromotionService {

    @Autowired
    private NewsOrPromotionRepository NewsOrPromotionRepository;

    // Implémentation des méthodes CRUD héritées de JpaRepository
    // Méthodes supplémentaires pour des opérations métier spécifiques
}

@Service
public class NewsOrPromotionServiceImpl implements NewsOrPromotionService {

    @Autowired
    private NewsOrPromotionRepository NewsOrPromotionRepository;

    // Implémentation des méthodes CRUD héritées de JpaRepository
    // Méthodes supplémentaires pour des opérations métier spécifiques
}