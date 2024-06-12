package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.Category;
import com.example.site_vitrine.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

     /** 
     * TODO: 
     * 
     *  1- Mettre à jour en fonction des changements sur les entités et les repositories
     *  2- Modifier les retours et les paramètres vers des DTO. Tenez à manipuler le moins possible les entités. 
     * 
     * */

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aucune catégorie avec cet id n'existe."));
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(UUID id, Category updatedCategory) {
        Category existingCategory = getCategoryById(id);
        existingCategory.setName(updatedCategory.getName());
        existingCategory.setDescription(updatedCategory.getDescription());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public boolean deleteCategory(UUID id) {
        Category existingCategory = getCategoryById(id);
        if (existingCategory != null) {
            categoryRepository.delete(existingCategory);
            return true;
        }
        return false;
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public List<Category> searchCategory(String keyword) {
        return List.of();
    }
}