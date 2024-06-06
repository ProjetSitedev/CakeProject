package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findByName(String name);
}
