	package com.aerotestx.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.apache.logging.log4j.Logger;

import com.aerotestx.utils.ConfigReader;
import com.aerotestx.utils.LogUtils;

public class ApiClient {
	private static final Logger logger = LogUtils.getLogger(ApiClient.class);

	public static Response get(
	        String endpoint) {

	    String baseUrl =
	            ConfigReader.getProperty("apiBaseUrl");

	    Response response = given()
	            .baseUri(baseUrl)
	            
	            .when()
	            .get(endpoint)
	            .then()
	            .extract()
	            .response();

	    return response;
	}
	
	public static Response get(
	        String endpoint,
	        String parameterName,
	        Object parameterValue) {

	    String baseUrl =
	            ConfigReader.getProperty("apiBaseUrl");

	    Response response = given()
	            .baseUri(baseUrl)
	            .pathParam(
	                    parameterName,
	                    parameterValue
	            )
	            .when()
	            .get(endpoint)
	            .then()
	            .extract()
	            .response();

	    return response;
	}
	public static Response post(
	        String endpoint,
	        Object body) {
		

	    String baseUrl =
	            ConfigReader.getProperty("apiBaseUrl");

	    logger.info(
	            "Sending POST request: {}{}",
	            baseUrl,
	            endpoint
	    );

	    Response response =
	            given()
	                    .baseUri(baseUrl)
	                    .contentType("application/json")
	                    .body(body)
	                    .when()
	                    .post(endpoint)
	                    .then()
	                    .extract()
	                    .response();

	    logger.info(
	            "POST response status: {}",
	            response.getStatusCode()
	    );

	    return response;
	}
	public static Response put(
	        String endpoint,
	        String parameterName,
	        Object parameterValue,
	        Object body) {

	    String baseUrl =
	            ConfigReader.getProperty("apiBaseUrl");

	    logger.info(
	            "Sending PUT request: {}{}",
	            baseUrl,
	            endpoint
	    );

	    Response response =
	            given()
	                    .baseUri(baseUrl)
	                    .pathParam(
	    	                    parameterName,
	    	                    parameterValue
	    	            )
	                    .contentType("application/json")
	                    .body(body)
	                    .when()
	                    .put(endpoint)
	                    .then()
	                    .extract()
	                    .response();

	    logger.info(
	            "PUT response status: {}",
	            response.getStatusCode()
	    );

	    return response;
	}
	public static Response delete(
	        String endpoint,
	        String parameterName,
	        Object parameterValue) {

	    String baseUrl =
	            ConfigReader.getProperty("apiBaseUrl");

	    logger.info(
	            "Sending DELETE request: {}{}",
	            baseUrl,
	            endpoint
	    );

	    Response response =
	            given()
	                    .baseUri(baseUrl)
                    .when()
                    .pathParam(
    	                    parameterName,
    	                    parameterValue
    	            )
	                    .delete(endpoint)
	                    .then()
	                    .extract()
	                    .response();

	    logger.info(
	            "DELETE response status: {}",
	            response.getStatusCode()
	    );

	    return response;
	}
}
