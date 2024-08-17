package com.example.VaccineManagementApplication.Exception;

public class InvalidEmailIdException extends RuntimeException {
    public InvalidEmailIdException(String message) {
        super(message);
    }
}
