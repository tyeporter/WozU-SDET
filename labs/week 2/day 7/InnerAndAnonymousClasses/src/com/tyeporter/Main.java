package com.tyeporter;

import com.tyeporter.innerclass.OuterClass;
import com.tyeporter.anonymousclass.AbstractClass;

/***********************************************************
 * This program demonstrates inner and anonymous classes
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-13-2020
 ***********************************************************/

public class Main {

    public static void main(String[] args) {
        // Create an Outer class object
        OuterClass outer = new OuterClass();

        // Create an Inner class object
        OuterClass.InnerClass inner = outer.new InnerClass("Inner Class");

        System.out.println(outer.getOuterString());
        System.out.println(inner.getInnerString());
        System.out.println(OuterClass.StaticInnerClass.STATIC_INNER_STRING);

        // Create an anonymous class from AbstractClass
        AbstractClass anon = new AbstractClass() {
            @Override
            public void abstractMethod() {
                System.out.println("I am running inside an anonymous class");
                
            }
        };

        // Call an method on the anonymous class
        anon.abstractMethod();
    }
    
}
