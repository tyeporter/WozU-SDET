package com.tyeporter.handson8.animal;

/****************************************
 * The Cat class...
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-15-2020
 ****************************************/

public class Cat implements Mammal {

    // =========================================================
    // Mammmal
    // =========================================================

    @Override
    public void speak() {
        System.out.println("Meow!");
    }

    @Override
    public void run() {
        System.out.println("Cats can run at a top speed of 30 mph!");
    }

    @Override
    public void eat() {
        System.out.println("Cats eat mice.");
    }
    
}
