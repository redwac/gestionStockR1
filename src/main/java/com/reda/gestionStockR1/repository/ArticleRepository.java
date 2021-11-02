package com.reda.gestionStockR1.repository;

import com.reda.gestionStockR1.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
