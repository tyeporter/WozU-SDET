package com.tyeporter;

import com.tyeporter.httpstatuscode.HTTPStatusCode;

/***********************************************************
 * This program demonstrates generics
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-13-2020
 ***********************************************************/

public class Main {

    public static void main(String[] args) {
        // Create an instance of HTTPStatusCode<T extends Number, E extends CharSequence>
        HTTPStatusCode<Integer, String> statusCode = new HTTPStatusCode<>();

        // Set some values on statusCode
        statusCode.setCode(403);
        statusCode.setMessage("Forbidden");

        // Print out the String representation of statusCode
        System.out.println(statusCode.toString());
    }
    
}
