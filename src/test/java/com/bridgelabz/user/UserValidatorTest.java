package com.bridgelabz.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class UserValidatorTest {

    UserValidator validator = new UserValidator();

    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
        boolean result = validator.validateFirstName("Mohit");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenWithTwoCharacter_ShouldReturnFalse() {
        try {
            boolean result = validator.validateFirstName("Mo");
        }catch (UserException exception) {
            Assertions.assertEquals(UserException.UserExceptionType.INVALID_FIRST_NAME, exception.type);
        }

    }

    @Test
    public void givenFirstName_WhenWithSpecialSymbol_ShouldReturnFalse() {
        try {
            boolean result = validator.validateFirstName("Mo#it");
        } catch (UserException exception) {
            Assertions.assertEquals(UserException.UserExceptionType.INVALID_FIRST_NAME, exception.type);
        }
    }

    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() {
        boolean result = validator.validateLastName("Kumar");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenTwoCharacter_ShouldReturnFalse() {
        try {
            boolean result = validator.validateLastName("Ku");
        } catch (UserException exception) {
            Assertions.assertEquals(UserException.UserExceptionType.INVALID_LAST_NAME, exception.type);
        }
    }

    @Test
    public void givenLastName_WhenSpecialSymbol_ShouldReturnFalse() {
        try {
            boolean result = validator.validateLastName("Kum@r");
        } catch (UserException exception) {
            Assertions.assertEquals(UserException.UserExceptionType.INVALID_LAST_NAME, exception.type);
        }
    }

    @Test
    public void givenEmail_WhenProper_ShouldReturnTrue() {
        boolean result = validator.validateEmail("abc.pqr@bridgelabz.co.in");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_WhenOnlyMandatoryPart_ShouldReturnTrue() {
        boolean result = validator.validateEmail("abc@bridgelabz.co");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMobileNumberWithCountryCode_WhenProper_ShouldReturnTrue() {
        boolean result = validator.validateMobileNumber("91 9999999999");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMobileNumberWithCountryCode_WhenNotProper_ShouldReturnFalse() {
        try {
            boolean result = validator.validateMobileNumber("919999999999");
        } catch(UserException exception) {
            Assertions.assertEquals(UserException.UserExceptionType.INVALID_MOBILE_NUMBER, exception.type);
        }
    }

    @Test
    public void givenMobileNumberWithCountryCode_WhenWithOutCode_ShouldReturnFalse() {
        try {
            boolean result = validator.validateMobileNumber("919999999999");
        } catch(UserException exception) {
            Assertions.assertEquals(UserException.UserExceptionType.INVALID_MOBILE_NUMBER, exception.type);
        }
    }

    @Test
    void givenPassword_WhenProper_ShouldReturnTrue() {
        boolean result = validator.validatePassword("Aa1@qwert");
        Assertions.assertTrue(result);
    }

    @Test
    void givenPassword_WhenNoSpecialCharacter_ShouldReturnFalse() {
        try {
            boolean result = validator.validatePassword("Aa1dgdhghjh");
        } catch(UserException exception) {
            Assertions.assertEquals(UserException.UserExceptionType.INVALID_PASSWORD, exception.type);
        }
    }

    @ParameterizedTest
    @MethodSource
    void givenListOfEmails_WhenProper_ShouldReturnTrue(String input) {
        Assertions.assertTrue(validator.validateEmail(input));
    }

    private static Stream<String> givenListOfEmails_WhenProper_ShouldReturnTrue(){
        return Stream.of("abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com", "abc-100@abc.net", "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com");
    }

    @ParameterizedTest
    @MethodSource
    void givenListOfEmails_WhenNotProper_ShouldReturnFalse(String input) {
        try {
            validator.validateEmail(input);
        } catch(UserException exception) {
            Assertions.assertEquals(UserException.UserExceptionType.INVALID_EMAIL, exception.type);
        }
    }

    private static Stream<String> givenListOfEmails_WhenNotProper_ShouldReturnFalse(){
        return Stream.of("abc","abc@.com.my","abc123@gmail.a","abc123@.com","abc123@.com.com",".abc@abc.com","abc()*@gmail.com","abc@%*.com","abc..2002@gmail.com","abc.@gmail.com","abc@abc@gmail.com","abc@gmail.com.1a","abc@gmail.com.aa.au");
    }

}
