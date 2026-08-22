package com.aerotestx.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aerotestx.base.BaseTest;
import com.aerotestx.data.FlightData;
import com.aerotestx.data.FlightRoute;
import com.aerotestx.models.Flight;
import com.aerotestx.pages.FlightResultPage;
import com.aerotestx.pages.FlightSearchPage;

public class SearchCheapestFlights extends BaseTest{
		
	@Test(description = "Getting list of cheapest flights for various locations", 
			dataProvider = "flightRoutes", dataProviderClass = FlightData.class)
	public void searchFlights(FlightRoute route) {
	FlightSearchPage searchPage = new FlightSearchPage(getDriver());
	// System.out.println("Searching: " + from + " -> " + to);
	searchPage.selectDepatureCity(route.getFrom());
	searchPage.selectDestiantionCity(route.getTO());
	searchPage.FindFlights();
	FlightResultPage results = new FlightResultPage(getDriver());

	Assert.assertTrue(results.isFlightResultsDisplayed(), "Flight results page was not displayed");

	List<Flight> flights = results.getAvailableFlights();
	System.out.println("Total flights found: " + flights.size());

	for (Flight flight : flights) {
		System.out.println(flight);
	}

	Flight cheapestFlight = results.getCheapestFlight();
	System.out.println("CheapestFlight: " + cheapestFlight);

	Assert.assertNotNull(cheapestFlight, "Cheapest flight was not found");

	results.selectFlight(cheapestFlight);
	}
}
