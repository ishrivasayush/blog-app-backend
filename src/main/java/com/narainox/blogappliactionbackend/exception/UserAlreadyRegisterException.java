package com.narainox.blogappliactionbackend.exception;

public class UserAlreadyRegisterException extends RuntimeException{
    public UserAlreadyRegisterException(String message) {
        super(message);
    }
}
