package com.reda.gestionStockR1.validator;

import com.reda.gestionStockR1.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto){
        List<String> errors = new ArrayList<>();
        if (articleDto == null){
            errors.add("Veuillez renseigner le nom de l'article");
            errors.add("Veuillez renseigner la quantite ");
            errors.add("Veuillei renseigner la category ");
        }

        if (!StringUtils.hasLength(articleDto.getNom())){
            errors.add("Veuillez renseigner le nom de l'article");
        }
        if (articleDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantite ");
        }
        if (articleDto.getCategoryDto() == null || articleDto.getCategoryDto().getId() == null){
            errors.add("Veuillei renseigner la category ");
        }
        return errors;
    }
}
