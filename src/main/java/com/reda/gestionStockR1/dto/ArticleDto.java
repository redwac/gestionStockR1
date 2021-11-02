package com.reda.gestionStockR1.dto;


import com.reda.gestionStockR1.model.Article;
import com.reda.gestionStockR1.model.Category;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ArticleDto {

    private Long id ;

    private String nom;

    private BigDecimal quantite;

    private CategoryDto categoryDto;

    public static ArticleDto fromEntity(Article article){
        if (article == null){
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .nom(article.getNom())
                .quantite(article.getQuantite())
                .categoryDto(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto){
        if (articleDto == null){
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setNom(articleDto.getNom());
        article.setQuantite(articleDto.getQuantite());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategoryDto()));

        return article ;
    }
}
