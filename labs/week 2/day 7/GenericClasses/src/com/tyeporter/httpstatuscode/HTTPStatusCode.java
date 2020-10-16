package com.tyeporter.httpstatuscode;

/***********************************************************
 * HTTPStatusCode is a class that represents Hypertext 
 * Transfer Protocol (HTTP) response status codes
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-13-2020
 ***********************************************************/

public class HTTPStatusCode<T extends Number, E extends CharSequence> {
    // Properties
    private T code; 
    private E message;

    // =========================================================
    // Setters
    // =========================================================

    public void setCode(T code) {
        this.code = code;
    }

    public void setMessage(E message) {
        this.message = message;
    }

    // =========================================================
    // Getters
    // =========================================================

    public T getCode() {
        return code;
    }

    public E getMessage() {
        return message;
    }

    // =========================================================
    // Overrides
    // =========================================================

    @Override
    public String toString() {
        return "(" + this.code + ", " + this.message + ")";
    }

}
