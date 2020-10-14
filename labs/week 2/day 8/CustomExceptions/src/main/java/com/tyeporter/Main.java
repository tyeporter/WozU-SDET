package com.tyeporter;

import java.util.Scanner;
import com.tyeporter.customexceptions.UsernameBoundsException;
import com.tyeporter.customexceptions.UsernameInvalidCharacterException;

/***********************************************************
 * This program demonstrates custom exceptions
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-14-2020
 ***********************************************************/

public class Main {

    public static void main( String[] args ) {
        // Declare variable to store user input
        String username;

        // Create Scanner object to read in user input
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a username: ");
        username = scanner.nextLine();

        // If user input is invalid, close scanner and throw our custom exception
        try {
            if (username.length() == 0 || username.length() >= 12) {
                scanner.close();
                throw new UsernameBoundsException(username.length());
            } else if (username.contains(" ")) {
                scanner.close();
                throw new UsernameInvalidCharacterException(" ");
            } else {
                System.out.println("That's a cool username!");
            }
        } catch (UsernameBoundsException | UsernameInvalidCharacterException e) {
            // Handle thrown exception
            e.printStackTrace();
        } finally {
            System.out.println("This prints to the console no matter what");
        }

        // Close scanner
        scanner.close();
    }
    
}
