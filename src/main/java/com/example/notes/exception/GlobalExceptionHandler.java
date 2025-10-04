package com.example.notes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoteNotFoundException.class)
        public ResponseEntity<ErrorResponse> notFound (NoteNotFoundException ex){
            ErrorResponse errorResponseObject = new ErrorResponse();
            errorResponseObject.setTimestamp(LocalDateTime.now().toString());
            errorResponseObject.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponseObject.setMessage(ex.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseObject);
        }
}
