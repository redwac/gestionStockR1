package com.reda.gestionStockR1.controller.api;

import com.reda.gestionStockR1.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.reda.gestionStockR1.utils.Constant.APP_ROOT;

@Api(APP_ROOT + "/commandeClient")
public interface CommandeClientApi {

    @PostMapping(value = APP_ROOT + "/cmdclt/create")
    CommandeClientDto save(@RequestBody CommandeClientDto dto);

    @GetMapping(value = APP_ROOT + "/cmdclt/{idCmd}")
    CommandeClientDto findById(@PathVariable("idCmd") Long id);

    @GetMapping(value = APP_ROOT + "/cmdclt/all")
    List<CommandeClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/cmdclt/delete/{idCmd}")
    void deleteById(@PathVariable("idCmd") Long id);
}
