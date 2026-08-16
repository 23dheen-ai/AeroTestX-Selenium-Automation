package com.aerotestx.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aerotestx.data.ApiTestData;

import io.restassured.response.Response;

public class PostApiTest extends BaseApiTest{

	private ApiClient apiClient =
            new ApiClient();
	
	@Test
	public void createGET() {
		
		Response response = apiClient.get(ApiEndpoints.postById(1));
		
		Assert.assertEquals(
                response.statusCode(),200);

		int createdId =
	            response.path("id");
		
        Assert.assertEquals(
        		createdId,1);

        int createdUser =
	            response.path("userId");
        
        Assert.assertEquals(
        		createdUser,1);
        
	}
	
	@Test
	public void createPOST() {
		
		String requestBody = ApiTestData.createPostRequest();
		
		Response response= apiClient.post(ApiEndpoints.POSTS, requestBody);
		
		Assert.assertEquals(
	            response.statusCode(), 201);

	    Assert.assertEquals(
	            response.path("title"),"AeroTestX API Test");

	    int createdUserId =
	            response.path("userId");
	    
	    Assert.assertEquals(
	    		createdUserId, 1);
	    
	    int createdPostId =
	            response.path("id");

	    Assert.assertTrue(
	            createdPostId > 0,
	            "Created post ID should be greater than zero");
		
	}
	
	public void extractPostId() {
		Response response =
	            apiClient.get(
	                    ApiEndpoints.postById(1));
		
		int postId = response.path("id");
		System.out.println("Post ID: " + postId);
		
		Assert.assertEquals(postId,1);
		
		
	}
}
