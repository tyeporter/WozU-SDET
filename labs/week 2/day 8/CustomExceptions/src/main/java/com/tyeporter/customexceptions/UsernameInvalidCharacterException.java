package com.tyeporter.customexceptions;

/***********************************************************
 * UsernameInvalidCharacterException represents an 
 * exception for invalid characters
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-14-2020
 ***********************************************************/

public class UsernameInvalidCharacterException extends Exception {

    public UsernameInvalidCharacterException(String invalidCharacter) {
        super("Username cannot contain invalid character \"" + invalidCharacter + "\"");
    }
    
}
