package com.tyeporter.handson8.animal;

/****************************************
 * The Cow class...
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-15-2020
 ****************************************/

public class Cow implements Mammal {

    // =========================================================
    // Mammmal
    // =========================================================

    @Override
    public void speak() {
        System.out.println("Moo!");
    }

    @Override
    public void run() {
        System.out.println("Cows can run at a top speed of 25 mph!");
    }

    @Override
    public void eat() {
        System.out.println("Cows eat grass.");
    }

}

