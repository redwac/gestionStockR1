package com.reda.gestionStockR1.validator;

import com.reda.gestionStockR1.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> validator(CommandeClientDto commandeClientDto){
        List<String> errors = new ArrayList<>();

        if (commandeClientDto == null){
            errors.add("Veuiller renseigner le code de la commande ");
            errors.add("Veuiller renseigner le prix total de la commande ");
            errors.add("Veuiller renseigner un client existe ");
        }

        if (!StringUtils.hasLength(commandeClientDto.getNumCommande())){
            errors.add("Veuiller renseigner le code de la commande ");
        }
        if (commandeClientDto.getTotalPrix() == null){
            errors.add("Veuiller renseigner le prix total de la commande ");
        }
        if (commandeClientDto.getClientDto() == null || commandeClientDto.getClientDto().getId() == null){
            errors.add("Veuiller renseigner un client existe ");
        }
        return errors;
    }
}
