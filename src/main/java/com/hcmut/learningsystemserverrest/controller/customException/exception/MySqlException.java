package com.hcmut.learningsystemserverrest.controller.customException.exception;

public class MySqlException extends RuntimeException{
    private final String message;

    public MySqlException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
