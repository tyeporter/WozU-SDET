package com.tyeporter.dogapiclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/***********************************************************
 * DopAPIClient is a class that can make GET request to 
 * the Dog API
 * 
 * https://dog.ceo/dog-api
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-16-2020
 ***********************************************************/

public class DogAPIClient {

    // =========================================================
    // Dop API Client Enpoints
    // =========================================================
    enum Endpoints {
        ALL_BREEDS,
        RANDOM_IMAGE,
        BREED_IMAGES,
        SUB_BREEDS;
        
        // Enpoint base
        public static final String BASE = "https://dog.ceo/api";

        public String stringValue(String breed) {
            switch (this) {
                case ALL_BREEDS:
                    return Endpoints.BASE + "/breeds/list/all";
                case RANDOM_IMAGE:
                    return Endpoints.BASE + "/breeds/image/random";
                case BREED_IMAGES:
                    return Endpoints.BASE + "/breed" + breed + "images";
                case SUB_BREEDS:
                    return Endpoints.BASE + "/breed/" + breed + "/list";
                default:
                    return "";
            }
        }

        public URI uri(String breed) {
            return URI.create(this.stringValue(breed));
        }
    }

    // =========================================================
    // Dop API Client Methods
    // =========================================================

    public static String getAllBreeds() {
        return makeGETRequest(Endpoints.ALL_BREEDS.uri(""));
    }

    public static String getRandomImage() {
        return makeGETRequest(Endpoints.RANDOM_IMAGE.uri(""));
    }

    public static String getBreedImages(String breed) {
        return makeGETRequest(Endpoints.BREED_IMAGES.uri(breed));
    }

    public static String getSubBreeds(String breed)  {
        return makeGETRequest(Endpoints.SUB_BREEDS.uri(breed));
    }

    // =========================================================
    // Networking Methods
    // =========================================================

    private static String makeGETRequest(URI uri) {
        try {
            // Create a new HttpClient object
            HttpClient client = HttpClient.newHttpClient();
            // Create a new HttpRequest object
            HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

            // Create a new HttpResponse object
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            // Return response body
            return response.body();
        } catch (Exception e) {
            return "Unable to request " + uri.toString() + " from API";
        }
    }
    
}
