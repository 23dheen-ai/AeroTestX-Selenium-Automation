package com.aerotestx.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aerotestx.database.BookingQueries;
import com.aerotestx.database.DatabaseUtils;

import io.restassured.response.Response;

public class UserCrudTest {
	
	@Test(
	        description =
	            "Validate API user data against MySQL",
	        groups = {"api", "database", "regression"}
	    )
	    public void validateUserApiAgainstDatabase()
	            throws Exception {

	        // 1. Get user ID from database
	        String userId =
	                DatabaseUtils.getSingleValue(
	                    "SELECT id FROM users LIMIT 1",
	                    "id"
	                );

	        Assert.assertNotNull(
	                userId,
	                "User ID should exist in database"
	        );

	        // 2. Get user data from database
	        String dbName =
	                DatabaseUtils.getSingleValue(
	                    BookingQueries.getUserById(userId),
	                    "name"
	                );

	        String dbEmail =
	                DatabaseUtils.getSingleValue(
	                    BookingQueries.getUserById(userId),
	                    "email"
	                );

	        // 3. Send API request using DB ID
	        Response response =
	                ApiClient.get(
	                    ApiEndpoints.USER_BY_ID,
	                    "id",
	                    userId
	                );
	        

	        // 4. Validate API response
	        Assert.assertEquals(
	                response.getStatusCode(),
	                200,
	                "API should return HTTP 200"
	        );

	        // 5. Extract API values
	        String apiId =
	                response.jsonPath()
	                        .getString("id");

	        String apiName =
	                response.jsonPath()
	                        .getString("name");

	        String apiEmail =
	                response.jsonPath()
	                        .getString("email");

	        // 6. API vs Database validation
	        Assert.assertEquals(
	                apiId,
	                userId,
	                "API ID should match DB ID"
	        );

	        Assert.assertEquals(
	                apiName,
	                dbName,
	                "API name should match DB name"
	        );

	        Assert.assertEquals(
	                apiEmail,
	                dbEmail,
	                "API email should match DB email"
	        );

	        DatabaseUtils.closeConnection();
	    }
	
		}

