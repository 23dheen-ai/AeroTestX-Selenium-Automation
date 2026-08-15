package com.aerotestx.data;

import org.testng.annotations.DataProvider;

public class FlightData {

	@DataProvider(name="flightRoutes")
	public Object[][] flightRoutes() {
		return new Object[][] {
			{new FlightRoute("Boston","New York")},
			{new FlightRoute("Philadelphia", "London")},
			{new FlightRoute("Portland", "Rome")},
			{new FlightRoute("San Diego", "Berlin")},
			{new FlightRoute("São Paolo", "Buenos Aires")}
			
		};
	}
}
