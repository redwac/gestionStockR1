package com.reda.gestionStockR1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reda.gestionStockR1.model.Category;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Long id;

    private String type;

    private String description;

    @JsonIgnore
    private List<ArticleDto> articleDtos;

    public static CategoryDto fromEntity(Category category){
        if (category == null){
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .type(category.getType())
                .description(category.getDescription())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null){
            return null;
        }
        Category category = new Category();

        category.setId(categoryDto.getId());
        category.setType(categoryDto.getType());
        category.setDescription(categoryDto.getDescription());

        return category;
    }
}
