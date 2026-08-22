package com.aerotestx.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class UserApiTesting {
	
	//Here we are using 
	public String userId = "10";
	@Test(description = "Creating post request to test API", priority = 1)
	public void postRequest() {
		
		String body = 
				"{\n" +
					    "  \"name\": \"John\",\n" +
					    "  \"email\": \"john@example.com\",\n" +
					    "  \"age\": 30\n" +
					    "}";
		Response response = ApiClient.post(ApiEndpoints.USERS, body);
		Assert.assertEquals(201, response.getStatusCode());
	}
	
	@Test(description = "Getting posted request from the API", priority = 2)
	public void getRequest() {

		Response response = ApiClient.get(ApiEndpoints.USER_BY_ID,"id",userId);
		
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	@Test(description = "Updating the created request", priority = 3)
	public void updateRequest() {
		String updatedBody = 
				"{\n" +
					    "  \"name\": \"dheena\",\n" +
					    "  \"email\": \"dheena@example.com\",\n" +
					    "  \"age\": 29\n" +
					    "}";

		Response response = ApiClient.put(ApiEndpoints.USER_BY_ID, "id", userId, updatedBody);
		Assert.assertEquals(200,response.getStatusCode());
	}
	
	@Test(description = "Delete the updated request", priority = 4)
	public void deleteRequest() {
		
		Response response = ApiClient.delete(ApiEndpoints.USER_BY_ID, "id", userId);
		Assert.assertEquals(200,response.getStatusCode());
	}
	
	}
					    
