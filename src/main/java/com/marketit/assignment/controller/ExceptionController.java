package com.marketit.assignment.controller;

import com.marketit.assignment.exception.CustomException;
import com.marketit.assignment.exception.ErrorResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResult> handleCustomException(CustomException ex) {
        ErrorResult err = ex.getExceptionTypes().getErrorResult();
        return new ResponseEntity<>(err, err.getHttpStatus());
    }
}
