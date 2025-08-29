package edu.eci.ieti.ieti8.exception;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String id) {
        super("User with id '" + id + "' not found.");
    }
}
