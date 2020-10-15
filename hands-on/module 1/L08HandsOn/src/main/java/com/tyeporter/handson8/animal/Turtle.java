package com.tyeporter.handson8.animal;

/****************************************
 * The Turtle class...
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-15-2020
 ****************************************/

public class Turtle implements Reptile {

    // =========================================================
    // Reptile
    // =========================================================

    @Override
    public void crawl() {
        System.out.println("A turtle moves very slow.");
    }
    
    @Override
    public void eat() {
        System.out.println("Turtles eat lettuce.");
    }
}
