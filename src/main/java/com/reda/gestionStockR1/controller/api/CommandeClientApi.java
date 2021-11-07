package com.reda.gestionStockR1.controller.api;

import com.reda.gestionStockR1.dto.CommandeClientDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.reda.gestionStockR1.utils.Constant.APP_ROOT;

public interface CommandeClientApi {

    @PostMapping(value = APP_ROOT + "/cmdclt/create")
    CommandeClientDto save(CommandeClientDto dto);

    @GetMapping(value = APP_ROOT + "/cmdclt/{idCmd}")
    CommandeClientDto findById(@PathVariable("idCmd") Long id);

    @GetMapping(value = APP_ROOT + "/cmdclt/all")
    List<CommandeClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/cmdclt/delete/{idCmd}")
    void deleteById(@PathVariable("idCmd") Long id);
}
