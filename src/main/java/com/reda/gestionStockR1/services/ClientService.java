package com.reda.gestionStockR1.services;

import com.reda.gestionStockR1.dto.ClientDto;
import com.reda.gestionStockR1.model.Client;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto);

    ClientDto findById(Long id);

    List<ClientDto> findAll();

    void deleteById(Long id);
}
