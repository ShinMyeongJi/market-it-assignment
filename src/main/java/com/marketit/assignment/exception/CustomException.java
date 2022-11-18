package com.marketit.assignment.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final ExceptionTypes exceptionTypes;

    public CustomException(ExceptionTypes exceptionTypes) {
        super(exceptionTypes.getErrorResult().getMessage());
        this.exceptionTypes = exceptionTypes;
    }
}
