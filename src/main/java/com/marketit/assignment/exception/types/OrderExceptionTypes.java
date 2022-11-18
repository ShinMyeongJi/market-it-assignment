package com.marketit.assignment.exception.types;


import com.marketit.assignment.exception.ErrorResult;
import com.marketit.assignment.exception.ExceptionTypes;
import org.springframework.http.HttpStatus;

public enum OrderExceptionTypes implements ExceptionTypes {
    ORDER_NOT_FOUND() {
        @Override
        public ErrorResult getErrorResult() {
            return ErrorResult.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .exceptionType(this)
                    .message("주문 정보를 찾을 수 없습니다.")
                    .build();
        }
    }
}
