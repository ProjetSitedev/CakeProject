package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.StaticPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaticRepository extends JpaRepository<StaticPage, UUID> {

    StaticPage findByTitle(String title);
}
