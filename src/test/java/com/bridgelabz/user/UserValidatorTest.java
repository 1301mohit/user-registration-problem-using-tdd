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
    void givenLastName_WhenSpecialSymbol_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateLastName("Kum@r");
        Assertions.assertFalse(result);
    }


}
