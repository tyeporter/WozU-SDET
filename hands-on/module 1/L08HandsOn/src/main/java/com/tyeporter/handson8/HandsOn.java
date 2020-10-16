package com.tyeporter.handson8;

import com.tyeporter.handson8.animal.Cat;
import com.tyeporter.handson8.animal.Cow;
import com.tyeporter.handson8.animal.Dog;
import com.tyeporter.handson8.animal.Lizard;
import com.tyeporter.handson8.animal.Turtle;

/***********************************************************
 * This hand-on practice demonstrates interfaces and 
 * inhertitance
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-15-2020
 ***********************************************************/

public class HandsOn {
    
    public static void main(String[] args) {
        // Create objects that implement the Mammal interface
        Dog doggy = new Dog();
        Cat kitty = new Cat();
        Cow cowwy = new Cow();

        // Run the speak() method on the mammal object
        doggy.speak();
        kitty.speak();
        cowwy.speak();

        // Run the run() method on the mammal object
        doggy.run();
        kitty.run();
        cowwy.run();

        // Run the eat() method on the mammal object
        doggy.eat();
        kitty.eat();
        cowwy.eat();

        // Create objects that implement the Reptile interface
        Turtle tortie = new Turtle();
        Lizard lizzy = new Lizard();

        // Run the crawl() method on the reptile objects
        tortie.crawl();
        lizzy.crawl();

        // Run the eat() method on the reptile objects
        tortie.eat();   
        lizzy.eat();
    }

}
