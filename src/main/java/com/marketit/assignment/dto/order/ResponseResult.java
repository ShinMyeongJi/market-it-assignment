package com.marketit.assignment.dto.order;

import lombok.Data;

import org.springframework.http.HttpStatus;

@Data
public class ResponseResult<T> {
    private HttpStatus httpStatus;
    private T body;

    public ResponseResult(HttpStatus status, T body) {
        this.httpStatus = status;
        this.body = body;
    }
}
