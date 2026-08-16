package com.aerotestx.data;

public class ApiTestData {

	public static String createPostRequest() {

        return """
                {
                    "title": "AeroTestX API Test",
                    "body": "REST Assured automation",
                    "userId": 1
                }
                """;
    }
}
