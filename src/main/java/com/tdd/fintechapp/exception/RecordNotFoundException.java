package com.tdd.fintechapp.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecordNotFoundException extends RuntimeException{

    private String message;

    public RecordNotFoundException(String message){
        this.message = message;
    }
}
