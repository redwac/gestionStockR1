package com.reda.gestionStockR1.services;

import com.reda.gestionStockR1.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Long id);

    List<CategoryDto> findAll();

    void deleteById(Long id);
}
