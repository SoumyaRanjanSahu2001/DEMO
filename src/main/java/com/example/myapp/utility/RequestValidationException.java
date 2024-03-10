package com.example.myapp.utility;

public class RequestValidationException extends RuntimeException{
    public RequestValidationException(String message){
        super(message);
    }
}
