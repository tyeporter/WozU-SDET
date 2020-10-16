package com.tyeporter.recreatelinkedlist;

import com.tyeporter.recreatelinkedlist.util.NiceLinkedList;

/***********************************************************
 * This program uses a custom linked list implementation
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-16-2020
 ***********************************************************/

public class Main {

    public static void main(String[] args) {
        // Creating a NiceLinkedList object
        NiceLinkedList<String> myLinkedList = new NiceLinkedList<>("Javascript");
        System.out.println(myLinkedList.toString());

        // Adding items
        myLinkedList.add("Swift");
        myLinkedList.add("Java");
        myLinkedList.add("Python");
        myLinkedList.add(2, "Rust");
        System.out.println(myLinkedList.toString());

        // Removing an item
        String removedItem = myLinkedList.remove(4);
        System.out.println(removedItem);
        System.out.println(myLinkedList.toString());

        // Trying to add at index equal to or greater than size
        // TODO: Make class throw exception
        myLinkedList.add(myLinkedList.size(), "C++");
        System.out.println(myLinkedList.toString());
    }

}
