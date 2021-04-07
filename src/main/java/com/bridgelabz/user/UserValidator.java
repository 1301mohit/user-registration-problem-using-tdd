package com.bridgelabz.user;

import java.util.regex.Pattern;

public class UserValidator {

    private static final String NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}$";
    private static final String EMAIL_PATTERN = "^[a-z0-9]+([-.+_][a-z0-9]+)?[@][a-z0-9]+([.][a-z0-9]{2,})([.][a-z]{2,})?$";
    private static final String MOBILE_NUMBER_PATTERN = "^[0-9]{1,2}[ ][0-9]{10}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$";

    public boolean validateFirstName(String firstName) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        if(pattern.matcher(firstName).matches())
            return true;
        throw new UserException("Enter a valid first name", UserException.UserExceptionType.INVALID_FIRST_NAME);
    }

    public boolean validateLastName(String lastName) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        if(pattern.matcher(lastName).matches())
            return true;
        throw new UserException("Enter a valid last name", UserException.UserExceptionType.INVALID_LAST_NAME);
    }

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if(pattern.matcher(email).matches())
            return true;
        throw new UserException("Enter a valid email id", UserException.UserExceptionType.INVALID_EMAIL);
    }

    public boolean validateMobileNumber(String mobileNumber) {
        Pattern pattern = Pattern.compile(MOBILE_NUMBER_PATTERN);
        if(pattern.matcher(mobileNumber).matches())
            return true;
        throw new UserException("Enter a valid mobile number", UserException.UserExceptionType.INVALID_MOBILE_NUMBER);
    }

    public boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        if(pattern.matcher(password).matches())
            return true;
        throw new UserException("Enter a valid password", UserException.UserExceptionType.INVALID_PASSWORD);
    }
}
