package com.tyeporter.handson9;

import java.util.ArrayList;
import java.util.List;

import com.tyeporter.handson9.animal.Animal;
import com.tyeporter.handson9.animal.AnimalFactory;

/***********************************************************
 * This hand-on practice demonstrates the factory and 
 * builder design patterns.
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-17-2020
 ***********************************************************/

public class HandsOn {

    public static void main(String[] args) {
        // Create a new StudentHelper object

        // Create a new AnimalFactory object
        AnimalFactory animalFactory = new AnimalFactory();

        // Create an ArrayList of Animal objects
        List<Animal> animalList = new ArrayList<Animal>();

        // Welcome the user
        System.out.println("\nWelome to the Build-An-Aniaml workshop!");
        System.out.println("You have " + animalList.size() + " animals in your workshop.");

        String userInput = "";
        int dogCount = 0, catCount = 0, cowCount = 0;
        while(true) {
            // Prompt user to enter a new animal name or exit progarm
            System.out.print("\nEnter an animal name to build a new animal or exit workshop by typing \"exit\": ");
            // Store user input
            userInput = StudentHelper.ReadInputString();

            if (!userInput.equalsIgnoreCase("exit")) { // If input does not equal "exit"
                // Build Animal object (could be null)
                Animal newAnimal = animalFactory.buildAnimal(userInput);
                if (newAnimal == null) {
                    // 
                    System.out.println("Sorry, we don't recognize that animal. Please try again.");
                } else {
                    // Add the newly create Animal to list
                    animalList.add(newAnimal);
                    // Increment count based on user input
                    if (userInput.equalsIgnoreCase("dog")) { dogCount++; }
                    else if (userInput.equalsIgnoreCase("cat")) { catCount++; }
                    else if (userInput.equalsIgnoreCase("cow")) { cowCount++; }
                    // Inform the user about what they have added so far
                    System.out.println("You've added a " + newAnimal.getClass().getSimpleName() + " to your workshop.");
                    System.out.println("You now have " + animalList.size() + " animals in your workshop");
                }
            } else { 
                // Break out of the loop
                break; 
            }
        }

        // Inform the user of what they built in the workshop
        System.out.println("\nYou've built " + dogCount + " Dogs, " + catCount + " Cats, and " + cowCount + " Cows.");
        System.out.println("See you later!");
    }

}
