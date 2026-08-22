package com.aerotestx.data;

import org.testng.annotations.DataProvider;

public class FlightData {

	@DataProvider(name = "flightRoutes")
	public Object[][] flightRoutes() {
		return new Object[][] { { new FlightRoute("Boston", "New York") },
				{ new FlightRoute("Philadelphia", "London") }, { new FlightRoute("Portland", "Rome") },
				{ new FlightRoute("San Diego", "Berlin") }, { new FlightRoute("São Paolo", "Buenos Aires") }

		};
	}

	@DataProvider(name = "validateRoutes")
	public Object[][] validateRoutes() {
		return new Object[][] { { new FlightRoute("London", "New York") }, { new FlightRoute("India", "London") },
				{ new FlightRoute("China", "Philipins") }, { new FlightRoute("Mexico", "Cuba") },
				{ new FlightRoute("South Africa", "Buenos Aires") }

		};
	}
}
