package com.aerotestx.data;

public class FlightRoute {

	private String from;
	private String to;

	public FlightRoute(String from, String to) {

		this.from = from;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public String getTO() {
		return to;
	}

	@Override
	public String toString() {

		return from + " -> " + to;
	}

}
