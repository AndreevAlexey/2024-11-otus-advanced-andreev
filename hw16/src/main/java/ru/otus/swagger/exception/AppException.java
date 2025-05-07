package ru.otus.swagger.exception;

public class AppException extends RuntimeException{
    public AppException(String message) {
        super(message);
    }
}
