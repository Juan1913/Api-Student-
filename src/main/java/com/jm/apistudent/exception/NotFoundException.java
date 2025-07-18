package com.jm.apistudent.exception;

public class NotFoundException extends RuntimeException {

    private final String message;

    public NotFoundException(String message) {
        this.message = message;
    }

    public  String getMessage() {
        return this.message;
    }

}
