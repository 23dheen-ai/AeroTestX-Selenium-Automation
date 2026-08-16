package com.aerotestx.api;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseApiTest {

	@BeforeClass
	public void setUp() {
		RestAssured.requestSpecification = ApiSpecifications.requestSpecification();
		
		RestAssured.responseSpecification = ApiSpecifications.responseSpecification();
	}
}
