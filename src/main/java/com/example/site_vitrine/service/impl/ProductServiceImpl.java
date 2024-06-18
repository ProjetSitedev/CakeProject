package com.example.site_vitrine.service.impl;

import com.example.site_vitrine.dto.ProductDTO;
import com.example.site_vitrine.dto.UpdateProductDTO;
import com.example.site_vitrine.entities.Product;
import com.example.site_vitrine.repository.ProductRepository;
import com.example.site_vitrine.service.ProductService;
import com.example.site_vitrine.utils.ConversionUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getProductById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));
        return convertToDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO createProduct(Product createProductDTO) {
        Product product = convertToEntity(createProductDTO);
        return convertToDTO(productRepository.save(product));
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(UUID id, UpdateProductDTO updateProductDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));

        existingProduct.setName(updateProductDTO.getName());
        existingProduct.setPrice(updateProductDTO.getPrice());
        existingProduct.setImageURL(updateProductDTO.getImageURL());

        return convertToDTO(productRepository.save(existingProduct));
    }

    @Override
    @Transactional
    public boolean deleteProduct(UUID id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));

        productRepository.delete(existingProduct);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO findProductByName(String productName) {
        Product product = productRepository.findByName(productName)
                .orElseThrow(() -> new EntityNotFoundException("Product with name " + productName + " not found"));
        return convertToDTO(product);
    }

    private ProductDTO convertToDTO(Product product) {
        return ConversionUtil.convertToDTO(product);
    }

    private Product convertToEntity(Product createProductDTO) {
        Product product = new Product();
        product.setName(createProductDTO.getName());
        product.setPrice(createProductDTO.getPrice());
        product.setImageURL(createProductDTO.getImageURL());
        return product;
    }
}
