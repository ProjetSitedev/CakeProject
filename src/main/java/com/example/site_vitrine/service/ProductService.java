package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(UUID id);

    Product createProduct(Product product);

    Product updateProduct(UUID id, Product updatedProduct);

    boolean deleteProduct(UUID id);

    List<Product> searchProducts(String keyword);

    Product findProductByName(String productName);


}
