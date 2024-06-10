package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.Category;
import com.example.site_vitrine.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(UUID id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    @Override
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(UUID id, Category updatedCategory){
        Category existingCategory = getCategoryById(id);
        if(existingCategory != null){
            existingCategory.setName(updatedCategory.getName());
            existingCategory.setDescription(updatedCategory.getDescription());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    @Override
    public boolean deleteCategory(UUID id){
        Category existingCategory = getCategoryById(id);
        if(existingCategory != null){
            categoryRepository.delete(existingCategory);
            return true;
        }
        return false;
    }

    @Override
    public Category findCategoryByName(String categoryName){
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public List<Category> searchCategory(String keyword) {
        return List.of();
    }
}
