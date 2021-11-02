package com.reda.gestionStockR1.repository;

import com.reda.gestionStockR1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
