package com.reda.gestionStockR1.controller.api;


import com.reda.gestionStockR1.dto.ArticleDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.reda.gestionStockR1.utils.Constant.APP_ROOT;


public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/article/create")
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/article/{idArticle}")
    ArticleDto findById(@PathVariable("idArticle") Long id);

    @GetMapping(value = APP_ROOT + "/article/all")
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/article/delete/{idArticle}")
    void deleteById(@PathVariable("idArticle") Long id);

}
