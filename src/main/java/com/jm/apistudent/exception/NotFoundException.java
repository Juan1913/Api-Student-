package com.jm.apistudent.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final String message;

    public NotFoundException(String message) {
        this.message = message;
    }

}
