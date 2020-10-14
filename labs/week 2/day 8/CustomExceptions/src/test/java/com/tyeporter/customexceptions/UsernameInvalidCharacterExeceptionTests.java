package com.tyeporter.customexceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsernameInvalidCharacterExeceptionTests {
    // Test Properties
    CustomExceptionsHelper exceptionHelper;
    String spaceCharacter = " ";

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
    void testUsernameInvalidCharacterException_SpaceCharacter() {
        assertThrows(UsernameInvalidCharacterException.class, () -> exceptionHelper.checkUsername(spaceCharacter));
    } 
    
}
