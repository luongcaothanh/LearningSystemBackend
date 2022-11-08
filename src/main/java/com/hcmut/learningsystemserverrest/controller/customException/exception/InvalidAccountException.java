package com.hcmut.learningsystemserverrest.controller.customException.exception;

public class InvalidAccountException extends RuntimeException{
    private final String message = "Invalid username or password";

    @Override
    public String getMessage() {
        return message;
    }
}
