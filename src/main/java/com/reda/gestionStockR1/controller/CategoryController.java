package com.reda.gestionStockR1.controller;

import com.reda.gestionStockR1.controller.api.CategoryApi;
import com.reda.gestionStockR1.dto.CategoryDto;
import com.reda.gestionStockR1.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryService.findById(id);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void deleteById(Long id) {
        categoryService.deleteById(id);
    }
}
