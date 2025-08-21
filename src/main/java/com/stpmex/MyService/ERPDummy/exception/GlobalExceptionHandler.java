package com.stpmex.MyService.ERPDummy.exception;

import com.stpmex.MyService.ERPDummy.dto.InvoiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InvoiceResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        
        InvoiceResponse response = new InvoiceResponse(
            null,
            null,
            null,
            "Error de validación: " + errorMessage
        );
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
