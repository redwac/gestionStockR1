package com.reda.gestionStockR1.services;

import com.reda.gestionStockR1.dto.UtilisateurDto;
import com.reda.gestionStockR1.model.Utilisateurs;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Long id);

    UtilisateurDto findByEmail(String email);

    List<UtilisateurDto> findAll();

    void deleteById(Long id);
}
