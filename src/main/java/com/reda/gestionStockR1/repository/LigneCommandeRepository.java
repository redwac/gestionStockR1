package com.reda.gestionStockR1.repository;

import com.reda.gestionStockR1.model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
}
