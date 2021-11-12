package com.reda.gestionStockR1.repository;

import com.reda.gestionStockR1.model.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateurs, Long> {

    //@Query(value = "select u from utilisateurs u where u.email = :email")
    Optional<Utilisateurs> findUtilisateursByEmail(String email);
}
