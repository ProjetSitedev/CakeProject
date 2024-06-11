package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByNameContainingIgnoreCase(String name);
    Product findByName(String name);

}
