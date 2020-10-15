package com.tyeporter.handson8.animal;

/****************************************
 * The Dog class...
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-15-2020
 ****************************************/

public class Dog implements Mammal {

    // =========================================================
    // Mammmal
    // =========================================================

    @Override
    public void speak() {
        System.out.println("Bark!");
    }

    @Override
    public void run() {
        System.out.println("Dogs can run at a top speed of 45 mph!");
    }

    @Override
    public void eat() {
        System.out.println("Dogs eat bones.");
    }

}
