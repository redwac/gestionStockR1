package com.reda.gestionStockR1.validator;

import com.reda.gestionStockR1.dto.LigneCommandeDto;
import com.reda.gestionStockR1.model.LigneCommande;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeValidator {

    public static List<String> validator(LigneCommandeDto ligneCommandeDto){
        List<String> errors = new ArrayList<>();

        if (ligneCommandeDto == null){
            errors.add("veuiller renseigner la quantite");
            errors.add("veuiller renseigner un article existe ");
            errors.add("veuiller renseigner la quantite");
        }
        if (ligneCommandeDto.getQuantite() == null){
            errors.add("veuiller renseigner la quantite");
        }
        if (ligneCommandeDto.getArticleDto() == null || ligneCommandeDto.getArticleDto().getId() == null){
            errors.add("veuiller renseigner un article existe ");
        }
        if (ligneCommandeDto.getCommandeClientDto() == null || ligneCommandeDto.getCommandeClientDto().getId() == null){
            errors.add("veuiller renseigner la quantite");
        }
        return errors;
    }
}
