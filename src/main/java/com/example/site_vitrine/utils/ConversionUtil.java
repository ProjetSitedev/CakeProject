package com.example.site_vitrine.utils;

import com.example.site_vitrine.dto.CreateProductDTO;
import com.example.site_vitrine.dto.ProductDTO;
import com.example.site_vitrine.entities.Product;

import java.math.BigDecimal;

public class ConversionUtil {

    public static ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(BigDecimal.valueOf(product.getPrice()));
        productDTO.setImageURL(product.getImageURL());
        return productDTO;
    }

    public static Product convertToEntity(CreateProductDTO createProductDTO) {
        Product product = new Product();
        product.setName(createProductDTO.getName());
        product.setPrice(createProductDTO.getPrice());
        product.setImageURL(createProductDTO.getImageURL());
        return product;
    }
}
