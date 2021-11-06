package com.reda.gestionStockR1.services;

import com.reda.gestionStockR1.dto.ArticleDto;

import java.util.List;

public interface ArticleService {


    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Long id);

    ArticleDto findArticleByNom(String nom);

    List<ArticleDto> findAll();

    void delete(Long id);
}
