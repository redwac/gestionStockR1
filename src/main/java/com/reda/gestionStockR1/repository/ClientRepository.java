package com.reda.gestionStockR1.repository;

import com.reda.gestionStockR1.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
