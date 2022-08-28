package com.example.myyahoo.exceptions;

public class BoardNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;

    public BoardNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
