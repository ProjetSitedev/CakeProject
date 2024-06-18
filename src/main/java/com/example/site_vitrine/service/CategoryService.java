package com.example.site_vitrine.service;

import com.example.site_vitrine.dto.CategoryDTO;
import com.example.site_vitrine.dto.CreateCategoryDTO;
import com.example.site_vitrine.dto.UpdateCategoryDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryDTO> getAllCategory();

    CategoryDTO getCategoryById(UUID id);

    CategoryDTO createCategory(CreateCategoryDTO createCategoryDTO);

    CategoryDTO updateCategory(UUID id, UpdateCategoryDTO updateCategoryDTO);

    boolean deleteCategory(UUID id);

    CategoryDTO findCategoryByName(String categoryName);

    List<CategoryDTO> searchCategory(String keyword);
}
