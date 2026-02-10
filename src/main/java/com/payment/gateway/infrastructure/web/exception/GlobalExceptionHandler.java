package com.payment.gateway.infrastructure.web.exception;

import com.payment.gateway.domain.exception.InvalidPaymentException;
import com.payment.gateway.infrastructure.web.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidPaymentException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPaymentException(InvalidPaymentException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "INVALID_PAYMENT",
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
