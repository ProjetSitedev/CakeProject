package com.example.site_vitrine.controller;

import com.example.site_vitrine.entities.Category;
import com.example.site_vitrine.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable UUID id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable UUID id, @RequestBody Category updatedCategory) {
        Category category = categoryService.updateCategory(id, updatedCategory);
        if (category != null) {
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        boolean deleted = categoryService.deleteCategory(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Category>> searchCategory(@RequestParam("keyword") String keyword) {
        List<Category> categories = categoryService.searchCategory(keyword);
        return ResponseEntity.ok(categories);
    }
}
