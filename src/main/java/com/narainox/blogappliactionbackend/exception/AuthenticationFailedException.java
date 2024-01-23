package com.narainox.blogappliactionbackend.exception;

public class AuthenticationFailedException extends RuntimeException{

    public AuthenticationFailedException(String message) {
        super(message);
    }
}
