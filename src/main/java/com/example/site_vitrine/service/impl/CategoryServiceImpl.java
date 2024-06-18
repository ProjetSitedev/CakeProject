package com.example.site_vitrine.service.impl;

import com.example.site_vitrine.dto.CategoryDTO;
import com.example.site_vitrine.dto.CreateCategoryDTO;
import com.example.site_vitrine.dto.UpdateCategoryDTO;
import com.example.site_vitrine.entities.Category;
import com.example.site_vitrine.repository.CategoryRepository;
import com.example.site_vitrine.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        return convertToDTO(category);
    }

    @Override
    public CategoryDTO createCategory(CreateCategoryDTO createCategoryDTO) {
        Category category = convertToEntity(createCategoryDTO);
        return convertToDTO(categoryRepository.save(category));
    }

    @Override
    public CategoryDTO updateCategory(UUID id, UpdateCategoryDTO updateCategoryDTO) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        existingCategory.setName(updateCategoryDTO.getName());
        existingCategory.setDescription(updateCategoryDTO.getDescription());

        return convertToDTO(categoryRepository.save(existingCategory));
    }

    @Override
    public boolean deleteCategory(UUID id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        categoryRepository.delete(existingCategory);
        return true;
    }

    @Override
    public CategoryDTO findCategoryByName(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        if (category == null) {
            throw new EntityNotFoundException("Category not found");
        }
        return convertToDTO(category);
    }

    @Override
    public List<CategoryDTO> searchCategory(String keyword) {
        return categoryRepository.findByNameContaining(keyword).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }

    private Category convertToEntity(CreateCategoryDTO createCategoryDTO) {
        Category category = new Category();
        category.setName(createCategoryDTO.getName());
        category.setDescription(createCategoryDTO.getDescription());
        return category;
    }
}
