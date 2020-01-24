package com.carros.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseBody
    public ResponseEntity errorNotFound(Exception ex){
        return  ResponseEntity.notFound().build();
    }
}
