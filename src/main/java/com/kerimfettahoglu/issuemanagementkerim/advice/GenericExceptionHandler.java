package com.kerimfettahoglu.issuemanagementkerim.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@RestControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    private final boolean debugMode = false;

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleExceptions(Exception ex, WebRequest webRequest) {
        if(debugMode==false) {
            ExceptionDto exceptionDto = new ExceptionDto(new Date(), ex.getMessage());
            return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(ex, HttpStatus.NOT_ACCEPTABLE);
    }
}
