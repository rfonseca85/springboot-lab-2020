package com.springbootlab.exceptions;

public class JsonSerializationException extends Exception{
    private String message;

    public JsonSerializationException(String message) {
        super(message);
    }
}
