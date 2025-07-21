package com.jm.apistudent.exception;

import lombok.Getter;

@Getter
public class NotSaveException extends RuntimeException{

    private final String message;

    public NotSaveException(String message) {
        this.message = message;
    }

}
