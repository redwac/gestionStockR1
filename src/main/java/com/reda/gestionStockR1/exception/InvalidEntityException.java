package com.reda.gestionStockR1.exception;

import lombok.Getter;

import java.util.List;

// cette classe sera invoquer qu'on  veux enregistrer sur la base données ou qu'on passe par les validator
public class InvalidEntityException extends RuntimeException{

    @Getter
    private ErrorsCode errorsCode;

    @Getter
    private List<String> errorsList;

    public InvalidEntityException(String message) {
        super(message);
    }
    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidEntityException(String message, Throwable cause, ErrorsCode errorsCode) {
        super(message, cause);
    }
    public InvalidEntityException(String message, ErrorsCode errorsCode){
        super(message);
        this.errorsCode = errorsCode;
    }
    public InvalidEntityException(String message, ErrorsCode errorsCode, List<String> errorList){
        super(message);
        this.errorsCode = errorsCode;
        this.errorsList = errorList;
    }
}
