package com.reda.gestionStockR1.exception;

import lombok.Getter;

public class NotFoundException extends RuntimeException {

    @Getter
    private ErrorsCode errorsCode;

    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public NotFoundException(String message, Throwable cause, ErrorsCode errorsCode) {
        super(message, cause);
        this.errorsCode = errorsCode;
    }
    public NotFoundException(String message, ErrorsCode errorsCode) {
        super(message);
        this.errorsCode = errorsCode ;
    }
}
