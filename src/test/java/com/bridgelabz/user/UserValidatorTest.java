package com.bridgelabz.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UserValidatorTest {

    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("Mohit");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenWithTwoCharacter_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("Mo");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenFirstName_WhenWithSpecialSymbol_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("mo@it");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateLastName("Kumar");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenTwoCharacter_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateLastName("Ku");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenLastName_WhenSpecialSymbol_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateLastName("Kum@r");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenEmail_WhenProper_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateEmail("abc.pqr@bridgelabz.co.in");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_WhenOnlyMandatoryPart_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateEmail("abc@bridgelabz.co");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMobileNumberWithCountryCode_WhenProper_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobileNumber("91 9999999999");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMobileNumberWithCountryCode_WhenNotProper_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobileNumber("919999999999");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenMobileNumberWithCountryCode_WhenWithOutCode_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobileNumber("9999999999");
        Assertions.assertFalse(result);
    }

}
