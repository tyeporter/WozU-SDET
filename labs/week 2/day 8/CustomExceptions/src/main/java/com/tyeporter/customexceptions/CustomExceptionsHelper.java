package com.tyeporter.customexceptions;

public class CustomExceptionsHelper {

    public void checkUsername(String username) throws Exception {
        // If user input is invalid, close scanner and throw our custom exception
        if (username.length() == 0 || username.length() >= 12) {
            throw new UsernameBoundsException(username.length());
        } else if (username.contains(" ")) {
            throw new UsernameInvalidCharacterException(" ");
        }
    }
    
}
