package com.demo.emp.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class empServiceExceptionHandler {
    @ExceptionHandler(value = {empServiceException.class})
    public ResponseEntity<Object> handlerEmpServiceException(empServiceException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(),new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);

    }
}
