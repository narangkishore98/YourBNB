package com.yourbnb.exceptions;

public class InvalidPropertyException extends RuntimeException {
    private String message;
    public InvalidPropertyException(String message)
    {
        super();
        this.message = message;
    }
    public String toString()
    {
        return message;
    }
}
