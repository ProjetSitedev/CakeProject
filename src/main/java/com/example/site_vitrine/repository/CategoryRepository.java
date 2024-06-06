package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category,UUID> {

    Category findByName(String name);
}
