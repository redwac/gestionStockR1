package com.reda.gestionStockR1.exception;

public enum  ErrorsCode {

    ARTICLE_NOT_FOUNT(1000),
    CATEGORY_NOT_FOUND(2000),
    CLIENT_NOT_FOUND(3000),
    COMMANDE_CLIENT_NOT_FOUND(4000),
    LIGNE_COMMANDE_NOT_FOUND(5000);


    private int code;

    ErrorsCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
