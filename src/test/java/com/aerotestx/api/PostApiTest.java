package com.aerotestx.api;

import org.testng.annotations.Test;

import com.aerotestx.data.ApiTestData;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostApiTest extends BaseApiTest {

	@Test
	public void getPost() {

		 given()

				.when().get("/posts/1")

				.then().statusCode(200)
	            .body("id", equalTo(1))
	            .body("userId", equalTo(1))
	            .body("title", notNullValue())
	            .body("body", notNullValue());

	}

	@Test
	public void createPost() {

		String requestBody = ApiTestData.createPostRequest();

		given().contentType("application/json").body(requestBody)

				.when().post("/posts")

				.then().statusCode(201).body("title", equalTo("AeroTestX API Test"))
				.body("body", equalTo("REST Assured automation")).body("userId", equalTo(1));

	}
	@Test
	public void ForInvalidPost() {

	    given()

	    .when()
	        .get("/posts/99999999")

	    .then()
	        .statusCode(404);
	}
}
