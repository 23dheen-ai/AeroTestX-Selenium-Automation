package com.aerotestx.data;

public class ApiTestData {

	private String id;
	private String status;
	private String amount;
	private String authCode;

	// Constructor
	public ApiTestData(String id, String status, String amount, String authCode) {
		this.id = id;
		this.status = status;
		this.amount = amount;
		this.authCode = authCode;
	}

	// Getters
	public String getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public String getAmount() {
		return amount;
	}

	public String getAuthCode() {
		return authCode;
	}

	// Convert to JSON string (for API POST body)
	public String toJson() {
		return "{ \"id\":\"" + id + "\", " + "\"status\":\"" + status + "\", " + "\"amount\":\"" + amount + "\", "
				+ "\"authCode\":\"" + authCode + "\" }";
	}

}
