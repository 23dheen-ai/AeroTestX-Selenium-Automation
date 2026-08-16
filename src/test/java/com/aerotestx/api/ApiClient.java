package com.aerotestx.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;  
import static org.hamcrest.Matchers.*; 

public class ApiClient {

	public Response get(String endpoint) {

        return given()
                .get(endpoint);
    }

    public Response post(
            String endpoint,
            Object requestBody) {

        return given()
                .body(requestBody)
                .post(endpoint);
    }
}
