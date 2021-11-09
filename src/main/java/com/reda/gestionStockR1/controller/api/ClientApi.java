package com.reda.gestionStockR1.controller.api;

import com.reda.gestionStockR1.dto.ClientDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.reda.gestionStockR1.utils.Constant.APP_ROOT;


public interface ClientApi {

    @PostMapping(value = APP_ROOT + "/client/create")
    ClientDto save(@RequestBody ClientDto dto);

    @GetMapping(value = APP_ROOT + "/client/{idClient}")
    ClientDto findById(@PathVariable("idClient") Long id);

    @GetMapping(value = APP_ROOT + "/client/all")
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/client/delete/{idClient}")
    void deleteById(@PathVariable("idClient") Long id);
}
