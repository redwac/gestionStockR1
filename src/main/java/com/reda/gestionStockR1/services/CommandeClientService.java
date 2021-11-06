package com.reda.gestionStockR1.services;


import com.reda.gestionStockR1.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto findById(Long id);

    List<CommandeClientDto> findAll();

    void deleteById(Long id);

}
