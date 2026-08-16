package com.aerotestx.api;

public final class ApiEndpoints {

	private ApiEndpoints() {
		
	}
	
	public static final  String POSTS = "/posts";
	
	public static String postById(int id) {
		return POSTS +"/"+id;
	}

	 
}
