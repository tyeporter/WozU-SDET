package com.tyeporter.recreatelinkedlist.util;

/***********************************************************
 * NiceNode is a class that represents a node in a linked
 * list
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-16-2020
 ***********************************************************/

public class NiceNode<T> {
    // Properties
    // A node will only have two properties: value and next
    private T value;
    private NiceNode next;

    // =========================================================
    // Constructors
    // =========================================================

    public NiceNode(T value) {
        this.value = value;
    }

    // =========================================================
    // Value methods
    // =========================================================

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    // =========================================================
    // Next methods
    // =========================================================

    public void setNext(NiceNode next) {
        this.next = next;
    }

    public NiceNode getNext() {
        return next;
    }
}
