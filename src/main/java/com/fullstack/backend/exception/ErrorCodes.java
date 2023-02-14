package com.fullstack.backend.exception;

public enum ErrorCodes {
    BAD_CREDENTIALS(1),
    BOUTIQUE_NOT_FOUND(1000),
    BOUTIQUE_NOT_VALIDE(1001),
    CATEGORIE_NOT_FOND(2000),
    PRODUIT_NOT_FOUND(3000),
    USER_NOT_FOUND(4000),
    USER_CHANGE_MDP_OBJECT_NOT_VALIDE(5000),
    MDP_NOT_VALIDE(5001),
    MDP_NOT_EQUAL(5002),
    ROLE_NOT_FOUND(6000);
    private final int code;
    ErrorCodes(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
