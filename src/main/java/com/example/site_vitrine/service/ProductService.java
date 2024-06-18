package com.example.site_vitrine.service;

import com.example.site_vitrine.dto.ProductDTO;
import com.example.site_vitrine.dto.UpdateProductDTO;
import com.example.site_vitrine.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(UUID id);

    ProductDTO createProduct(Product createProductDTO);

    ProductDTO updateProduct(UUID id, UpdateProductDTO updateProductDTO);

    boolean deleteProduct(UUID id);

    List<ProductDTO> searchProducts(String keyword);

    ProductDTO findProductByName(String productName);
}
