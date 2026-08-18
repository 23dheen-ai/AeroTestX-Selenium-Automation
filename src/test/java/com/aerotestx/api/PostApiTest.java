package com.aerotestx.api;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aerotestx.data.ApiTestData;
import com.aerotestx.utils.LogUtils;

import io.restassured.response.Response;

public class PostApiTest extends BaseApiTest{

	private ApiClient apiClient =
            new ApiClient();
	private static final Logger log =
	        LogUtils.getLogger(PostApiTest.class);
	
	@Test
	public void createGET() {
		log.info("Starting GET post test");
		Response response = apiClient.get(ApiEndpoints.postById(1));
		
		log.info("API response status: {}",response.statusCode());
		        
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
        log.info("GET post validation completed");
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
	@Test
	public void extractPostId() {
		Response response =
	            apiClient.get(
	                    ApiEndpoints.postById(1));
		
		int postId = response.path("id");
		System.out.println("Post ID: " + postId);
		
		Assert.assertEquals(postId,1);
		
		
	}
}
