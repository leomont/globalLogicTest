package com.lmontes.globallogictest.config;

import com.lmontes.globallogictest.dto.ErrorResponse;
import com.lmontes.globallogictest.exception.LoginException;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.ConstraintViolationException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.*;
import javax.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(new Timestamp(System.currentTimeMillis()), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ConstraintViolationException ex) {
        List<String> messages = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        log.info(messages.toString());
        ErrorResponse errorResponse = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST.value(),
                messages.toString());
        return ResponseEntity.status(errorResponse.getCodigo()).body(errorResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleUniqueException(DataIntegrityViolationException ex) {
        log.info(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Se produjo una excepción de violación de integridad");
        return ResponseEntity.status(errorResponse.getCodigo()).body(errorResponse);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ErrorResponse> handleUniqueException(LoginException ex) {
        log.info(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage());
        return ResponseEntity.status(errorResponse.getCodigo()).body(errorResponse);
    }
}
