package com.petruckio.desafio_dio_banco.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<StandardError> handlerResourceNotFoundException(InvalidTransactionException e, HttpServletRequest request) {
        var error = e.getClass().getSimpleName();
        var status = HttpStatus.NOT_FOUND;
        var message = "Transaction invalid!";
        var standardError = new StandardError(Instant.now(), status.value(), error, message);

        return ResponseEntity.status(status).body(standardError);
    }
}