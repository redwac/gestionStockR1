package com.reda.gestionStockR1.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException2 extends RuntimeException{

    @Getter
    private ErrorsCode errorsCode;

    @Getter
    private List<String> errorsList;

    public InvalidEntityException2(String message) {
        super(message);
    }
    public InvalidEntityException2(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidEntityException2(String message, Throwable cause, ErrorsCode errorsCode) {
        super(message, cause);
    }
    public InvalidEntityException2(String message, ErrorsCode errorsCode){
        super(message);
        this.errorsCode = errorsCode;
    }
    public InvalidEntityException2(String message, ErrorsCode errorsCode, List<String> errorList){
        super(message);
        this.errorsCode = errorsCode;
        this.errorsList = errorList;
    }
}
