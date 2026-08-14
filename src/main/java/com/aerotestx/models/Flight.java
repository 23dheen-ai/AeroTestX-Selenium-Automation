package com.aerotestx.models;

public class Flight {

	private String airLine;
	private String flightNumber;
	private double price;
	
	public Flight(String airLine, String flightNumber, 
			double price) {
		
		this.airLine = airLine;
		this.flightNumber = flightNumber;
		this.price = price;
		
	}
	
	public String getAirline() {
		return airLine;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {

        return "Flight{" +
                "airline='" + airLine + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", price=" + price +
                '}';
    }
	
	
}
