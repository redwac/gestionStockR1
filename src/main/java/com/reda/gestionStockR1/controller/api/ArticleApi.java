package com.reda.gestionStockR1.controller.api;


import com.reda.gestionStockR1.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.reda.gestionStockR1.utils.Constant.APP_ROOT;

@Api(APP_ROOT + "/article")
public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/article/create")
    @ApiOperation(value = "Enregistrer un  article", notes = "cette fonction permet d'enregistrer ou de modifier un article", response = ArticleDto.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "l'article a ete crée avec succée"),
            @ApiResponse(code = 400, message = "L'objet article n'est pas valide")
    })
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/article/{idArticle}")
    @ApiOperation(value = "chercher un  article", notes = "cette fonction permet de chercher un article avec son ID ", response = ArticleDto.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "le recherche d'article OK"),
            @ApiResponse(code = 404, message = "Erreur au de niveau de la recheche d'article")
    })
    ArticleDto findById(@PathVariable("idArticle") Long id);

    @GetMapping(value = APP_ROOT + "/article/all")
    @ApiOperation(value = "Lister tous les  articles", notes = "cette fonction permet de Lister tous article de la base données ", response = ArticleDto.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Lister les article reussit OK"),
            @ApiResponse(code = 404, message = "Lister les article n'est pas reussit OK")
    })
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/article/delete/{idArticle}")
    @ApiOperation(value = "Supprimer article par ID", notes = "cette fonction permet de supprimer un article avec son ID  ", response = ArticleDto.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "l'article a été supprimer avec succée"),
            @ApiResponse(code = 400, message = "Erreur au niveau de suppression d'article ")
    })
    void deleteById(@PathVariable("idArticle") Long id);

}
