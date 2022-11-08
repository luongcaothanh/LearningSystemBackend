package com.hcmut.learningsystemserverrest.controller.customException;

import com.hcmut.learningsystemserverrest.controller.customException.exception.InvalidAccountException;
import com.hcmut.learningsystemserverrest.service.response.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomResponse> handleInvalidAccountException(InvalidAccountException ex) {
        CustomResponse response = new CustomResponse(ex.getMessage(), 400, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
