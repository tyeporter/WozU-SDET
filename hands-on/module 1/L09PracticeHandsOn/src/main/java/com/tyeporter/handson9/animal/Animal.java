package com.tyeporter.handson9.animal;

/****************************************************************
 * The Animal abstract class represents that all animals should 
 * inherit from
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-17-2020
 ****************************************************************/

public class Animal {
    // Properties
    private String name;
    private float length;
    private float height;
    private float weight;

    // Optional
    private boolean isGrassFed;

    // =========================================================
    // Builder
    // =========================================================

    public static class AnimalBuilder {
        // Required 
        private String name;
        private float length;
        private float height;
        private float weight;

        // Optional
        private boolean isGrassFed;

        public AnimalBuilder(String name, float length, float height, float weight) {
            this.name = name;
            this.length = length;
            this.height = height;
            this.weight = weight;
            this.isGrassFed = false;
        }

        // =========================================================
        // Builder methods
        // =========================================================

        public AnimalBuilder setIsGrassFed(boolean isGrassFed) {
            this.isGrassFed = isGrassFed;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }

    // =========================================================
    // Constructors
    // =========================================================

    private Animal(AnimalBuilder builder) {
        this.name = builder.name;
        this.length = builder.length;
        this.height = builder.height;
        this.weight = builder.weight;
        this.isGrassFed = builder.isGrassFed;
    }

    public Animal(String name, float length, float height, float weight) {
        this.name = name;
        this.length = length;
        this.height = height;
        this.weight = weight;
        this.isGrassFed = false;
    }

    // =========================================================
    // Getters
    // =========================================================

    public String getName() {
        return name;
    }

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isGrassFed() {
        return isGrassFed;
    }

    // =========================================================
    // Setters
    // =========================================================

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(float length) {
        this.length = length;
    }
    
    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setGrassFed(boolean isGrassFed) {
        this.isGrassFed = isGrassFed;
    }
}