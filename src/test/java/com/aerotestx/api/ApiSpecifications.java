package com.aerotestx.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;  
import static org.hamcrest.Matchers.*;

import com.aerotestx.utils.ConfigReader; 

public final class ApiSpecifications {

	private ApiSpecifications() {
		
	}

	public static RequestSpecification requestSpecification() {
		
		return new RequestSpecBuilder()
		.setBaseUri(ConfigReader.getProperty("api.base.url"))
		.setContentType("application/json").build();
	}
	
	public static ResponseSpecification responseSpecification() {
		return new ResponseSpecBuilder().expectResponseTime(lessThan(3000L)).build();	
	}
}
