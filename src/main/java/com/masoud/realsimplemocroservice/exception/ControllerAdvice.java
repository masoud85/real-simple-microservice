package com.masoud.realsimplemocroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidEmployeeException.class})
    public ResponseEntity<Object> handleInvalidEmployeeException(InvalidEmployeeException exception) {
        CustomError error = new CustomError(HttpStatus.BAD_REQUEST.value(), "An exception thrown "
                + exception.getLocalizedMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleGlobalException(RuntimeException exception) {
        CustomError error = new CustomError(HttpStatus.BAD_REQUEST.value(), "An exception thrown "
                + exception.getLocalizedMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
