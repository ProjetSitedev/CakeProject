package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.Product;
import com.example.site_vitrine.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {

     /** 
     * TODO: 
     * 
     *  1- Mettre à jour en fonction des changements sur les entités et les repositories
     *  2- Modifier les retours et les paramètres vers des DTO. Tenez à manipuler le moins possible les entités. 
     * 
     * */

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {this.productRepository = productRepository;}

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));
    }

    @Override
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(UUID id, Product updatedProduct){
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setImageURL(updatedProduct.getImageURL());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(UUID id) {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            productRepository.delete(existingProduct);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> searchProducts(String keyword){
        // TODO: Marquer les actions à faire ultérieurement en TODO
        return List.of();
    }

    @Override
    public Product findProductByName(String productName){
        return productRepository.findByName(productName);
    }
}
