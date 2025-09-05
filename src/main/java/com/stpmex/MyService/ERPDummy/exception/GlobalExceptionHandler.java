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
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();

        /*
        InvoiceResponse response = new InvoiceResponse(
            null,
            null,
            null,
            "Error de validación: " + errorMessage
        );
         */

        String response = "Returned a response status of 400 Bad Request]]><![CDATA[Invalid operation update for the specified resource..A 400 Bad Request Error indicates that the target service is unable (or refuses) to process the request sent by the client (Oracle Integration Cloud), due to an issue that is perceived by the server to be a client problem. You can trace the cURL representation of the request sent to the target service from the Oracle Integration Cloud server logs. Try invoking the target service using cURL. It may also be that one of the intermediaries (proxy, LBR) could be returning this code. ]]> :Application Errorexecute";
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
