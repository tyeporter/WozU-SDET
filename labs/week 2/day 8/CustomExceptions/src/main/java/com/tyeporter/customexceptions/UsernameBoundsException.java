package com.tyeporter.customexceptions;

/***********************************************************
 * UsernameBoundsException represents an exception for
 * character limit
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-14-2020
 ***********************************************************/

public class UsernameBoundsException extends Exception {

    private static final int CHARACTER_LIMIT = 12;

    public UsernameBoundsException(int stringLength) {
        super(stringLength == 0 ? "Username cannot be empty" : "Went over character limit (" + CHARACTER_LIMIT + ")");
    }
    
}
