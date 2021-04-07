package com.bridgelabz.user;

public class UserException extends RuntimeException {

    public enum UserExceptionType {
        INVALID_LAST_NAME, INVALID_MOBILE_NUMBER, INVALID_PASSWORD, INVALID_EMAIL, INVALID_FIRST_NAME
    }

    public UserExceptionType type;

    private String message;

    public UserException(String message, UserExceptionType type) {
        super(message);
        this.type = type;
    }

}
