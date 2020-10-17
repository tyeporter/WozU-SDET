package com.tyeporter.handson9.animal;

/****************************************************************
 * The AnimalFactory class is responsible for creating new 
 * Animal objects
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-17-2020
 ****************************************************************/

public class AnimalFactory {

    public Animal buildAnimal(String animalType) {
        if (animalType.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (animalType.equalsIgnoreCase("cat")) {
            return new Cat();
        } else if (animalType.equalsIgnoreCase("cow")) {
            return new Cow();
        } else {
            return null;
        }
    }

}