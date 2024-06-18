package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    /**
     * Toujours retourner des Optional dans le cas où le retour est unique.
     * Dans le cas où la valeur donnée ne correspond à aucune entrée, l'optional empty permettra d'anticiper d'éventuels NullPointerException.
     *
     * Optional<T> findByXYZ(String xyz);
     * */

    List<Product> findByNameContainingIgnoreCase(String name);
    Optional<Product> findByName(String name);
}
