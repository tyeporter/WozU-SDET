package com.tyeporter.customexceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsernameBoundsExceptionTests {
    // Test Properties
    CustomExceptionsHelper exceptionHelper;
    String zeroCharacters = "";
    String aboveTwelveCharacters = "thisusernameissuperlong"; 

    // =========================================================
	// Test Setup & Breakdown 
	// =========================================================

    @BeforeEach
    void setUp() {
        exceptionHelper = new CustomExceptionsHelper();
    }

    // =========================================================
	// Conditional Exception Handling 
	// =========================================================

    @Test
    void testUsernameBoundExecption_ZeroCharacters() {
        assertThrows(UsernameBoundsException.class, () -> exceptionHelper.checkUsername(zeroCharacters));
    } 

    @Test
    void testUsernameBoundExecption_AboveTwelveCharacters() {
        assertThrows(UsernameBoundsException.class, () -> exceptionHelper.checkUsername(aboveTwelveCharacters));
    } 
    
}
