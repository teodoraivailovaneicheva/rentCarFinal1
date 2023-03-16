package com.example.rentCarFinal.exception;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.sql.SQLIntegrityConstraintViolationException;

public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT) //posts duplicate when in entity is unique
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    String handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex){
        return "Duplicates not allowed";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecordNotFoundException.class)
    String handlerRecordNotFoundException(RecordNotFoundException ex){
        return ex.getMessage(); //in service will be specified
    }

    @ResponseStatus(HttpStatus.NOT_FOUND) //get not existing record
    @ExceptionHandler(EmptyResultDataAccessException.class)
    String handlerEmptyResultDataAccessException(EmptyResultDataAccessException ex){
        return "Record not found";
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RecordNotFoundException.class)
    String handleNoSuchElementException(RecordNotFoundException ex){
        return ex.getMessage();
    }

}