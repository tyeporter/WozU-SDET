package com.tyeporter.handson8.animal;

/****************************************
 * The Lizard class...
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-15-2020
 ****************************************/

public class Lizard implements Reptile {

    // =========================================================
    // Reptile
    // =========================================================

    @Override
    public void crawl() {
        System.out.println("Lizards are pretty swift.");
    }
    
    @Override
    public void eat() {
        System.out.println("Lizards eat crickets.");
    }
    
}
