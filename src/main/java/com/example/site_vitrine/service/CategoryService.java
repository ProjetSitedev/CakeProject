package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAllCategory();

    Category getCategoryById(UUID id);

    Category createCategory(Category category);

    Category updateCategory(UUID id, Category updatedCategory);

    boolean deleteCategory(UUID id);

    Category findCategoryByName(String categoryName);

    List<Category> searchCategory(String keyword);
}