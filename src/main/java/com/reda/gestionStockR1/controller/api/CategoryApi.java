package com.reda.gestionStockR1.controller.api;

import com.reda.gestionStockR1.dto.CategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.reda.gestionStockR1.utils.Constant.APP_ROOT;


public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/category/create")
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/category/{idCategory}")
    CategoryDto findById(@PathVariable("idCategory") Long id);

    @GetMapping(value = APP_ROOT + "/category/all")
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/category/delete/{idCategory}")
    void deleteById(@PathVariable("idCategory") Long id);
}
