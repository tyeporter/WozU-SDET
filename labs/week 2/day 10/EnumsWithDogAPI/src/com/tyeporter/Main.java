package com.tyeporter;

import com.tyeporter.dogapiclient.DogAPIClient;

/***********************************************************
 * Enums example using the Dop API
 * 
 * https://dog.ceo/dog-api
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-16-2020
 ***********************************************************/

public class Main {
    
    public static void main(String[] args) {
        System.out.println(DogAPIClient.getSubBreeds("hound"));
    }

}
