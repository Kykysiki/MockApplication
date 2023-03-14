package org.example;

public class UserNonUniqueException extends RuntimeException {
    public UserNonUniqueException(String message, String login) {
        super(message + " - " + login);
    }
}
