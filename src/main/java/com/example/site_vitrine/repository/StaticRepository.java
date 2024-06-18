package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.StaticPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StaticRepository extends JpaRepository<StaticPage, UUID> {
    Optional<StaticPage> findByTitle(String title);

    Optional<Object> findByTitleContaining(String keyword);
}