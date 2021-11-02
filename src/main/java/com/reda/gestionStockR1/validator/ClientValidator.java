package com.reda.gestionStockR1.validator;

import com.reda.gestionStockR1.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validator(ClientDto clientDto){
        List<String> errors = new ArrayList<>();

        if (clientDto == null){
            errors.add("Veuiller renseigner le nom du client ");
            errors.add("Veuiller renseigner le prenom du client ");
        }
        if (!StringUtils.hasLength(clientDto.getNom())){
            errors.add("Veuiller renseigner le nom du client ");
        }
        if (!StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("Veuiller renseigner le prenom du client ");
        }
        return errors;
    }
}
