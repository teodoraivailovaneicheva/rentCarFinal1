package com.example.rentCarFinal.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecordNotFoundException extends Exception {

    public RecordNotFoundException(String message) {

        super(message);
    }
}

