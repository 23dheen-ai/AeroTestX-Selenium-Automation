package com.aerotestx.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aerotestx.base.BaseTest;
import com.aerotestx.listeners.TestListener;
import com.aerotestx.models.Flight;
import com.aerotestx.pages.FlightResultPage;
import com.aerotestx.pages.FlightSearchPage;
@Listeners(TestListener.class)
public class FlightSearchTest extends BaseTest{

	@Test
	public void searchFlights() {
		
		FlightSearchPage searchPage = new FlightSearchPage(driver);
		
		searchPage.selectDepatureCity("Boston");
		searchPage.selectDestiantionCity("New York");
		searchPage.FindFlights();
		
		FlightResultPage results = new FlightResultPage(driver);
		
		Assert.assertTrue(results.isFlightResultsDisplayed(), "Flight results page was not displayed");
	
		List<Flight> flights = results.getAvailableFlights();
		System.out.println("Total flights found: " + flights.size());
		
		for (Flight flight : flights) {
			System.out.println(flight);
		}
		
		Flight cheapestFlight = results.getCheapestFlight();
		System.out.println("CheapestFlight: "+ cheapestFlight);
		
		Assert.assertNotNull(
                cheapestFlight,
                "Cheapest flight was not found"
        );
		
		results.selectFlight(cheapestFlight);
	}
	
}
