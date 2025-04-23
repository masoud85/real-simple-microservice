package com.masoud.realsimplemocroservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomError {
    private int errorCode;
    private String errorMessage;

}
