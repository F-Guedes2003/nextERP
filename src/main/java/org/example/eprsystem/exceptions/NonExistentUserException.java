package org.example.eprsystem.exceptions;

public class NonExistentUserException extends RuntimeException{
    @Override
    public String getMessage() {
        return "User not found";
    }
}
