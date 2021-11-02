package com.reda.gestionStockR1.validator;

import com.reda.gestionStockR1.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validator(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();
        if (categoryDto == null){
            errors.add("veuiller renseigner le type de category ");
            errors.add("veuiller renseigner la description ");

        }
        if (!StringUtils.hasLength(categoryDto.getType())){
            errors.add("veuiller renseigner le type de category ");
        }
        if (!StringUtils.hasLength(categoryDto.getDescription())){
            errors.add("veuiller renseigner la description ");
        }
        return errors;
    }
}
