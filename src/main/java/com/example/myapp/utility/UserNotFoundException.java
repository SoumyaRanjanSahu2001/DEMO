package com.example.myapp.utility;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String m){
        super(m);
    }
}
