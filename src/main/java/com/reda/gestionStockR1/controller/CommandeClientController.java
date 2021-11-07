package com.reda.gestionStockR1.controller;

import com.reda.gestionStockR1.controller.api.CommandeClientApi;
import com.reda.gestionStockR1.dto.CommandeClientDto;
import com.reda.gestionStockR1.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeClientController implements CommandeClientApi {

    CommandeClientService commandeClientService;

    @Autowired
    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        return commandeClientService.save(dto);
    }

    @Override
    public CommandeClientDto findById(Long id) {
        return commandeClientService.findById(id);
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientService.findAll();
    }

    @Override
    public void deleteById(Long id) {
        commandeClientService.deleteById(id);
    }
}
