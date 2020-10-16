package com.tyeporter.util;

import java.util.Arrays;

/***********************************************************
 * The NiceString class is a superficial and incomplete 
 * reimplementation of the String class used specifically
 * to demonstrate Unit Test competency
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-12-2020
 ***********************************************************/

public class NiceString {
    private char[] value;

    // =========================================================
    // Constructors
    // =========================================================

    public NiceString() {
        this.value = new char[0];
    }

    public NiceString(String orginal) {
        this.value = orginal.toCharArray();
    }

    public NiceString(char[] characters) {
        this.value = characters;
    }


    // =========================================================
    // Equate
    // =========================================================

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }

        NiceString castedObject = NiceString.class.cast(obj);
        return Arrays.equals(this.value, castedObject.value);
    }

    public boolean equalsIgnoreCase(NiceString obj) {
        if (obj == null) {
            return false;
        }

        return getValue().equalsIgnoreCase(obj.getValue());
    }


    // =========================================================
    // Query
    // =========================================================

    public char charAt(int index) {
        return this.value[index];
    }

    public boolean contains(String substring) {
        return getValue().contains(substring);
    }

    public boolean contains(NiceString substring) {
        return getValue().contains(substring.getValue());
    }

    public char[] getChars() {
        return this.value;
    }

    public int indexOf(char character) {
        if (this.value.length == 0) return -1;

        int index = -1;
        for (int i = 0; i < this.value.length; i++) {
            if (this.value[i] == character) index = i;
        }

        return index;
    }

    public boolean isEmpty() {
        return this.value.length == 0;
    }

    public int length() {
        return this.value.length;
    }


    // =========================================================
    // Modify
    // =========================================================

    public String concat(String otherString) {
        return getValue() + otherString;
    }

    public String concat(NiceString otherString) {
        return getValue() + otherString.getValue();
    }


    // =========================================================
    // Set
    // =========================================================

    public void setValue(String value) {
        this.value = value.toCharArray();
    }


    // =========================================================
    // Get
    // =========================================================

    public String getValue() {
        return String.valueOf(this.value);
    }
    
}