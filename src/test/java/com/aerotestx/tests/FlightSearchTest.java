package com.aerotestx.tests;

import java.util.List;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aerotestx.base.BaseTest;
import com.aerotestx.data.FlightData;
import com.aerotestx.data.FlightRoute;
import com.aerotestx.factory.DriverFactory;
import com.aerotestx.listeners.TestListener;
import com.aerotestx.models.Flight;
import com.aerotestx.pages.FlightResultPage;
import com.aerotestx.pages.FlightSearchPage;
import com.aerotestx.utils.LogUtils;

@Listeners(TestListener.class)
public class FlightSearchTest extends BaseTest {
	private static final Logger log = LogUtils.getLogger(FlightSearchTest.class);

	@Test(description = "Verify end-to-end booking for multiple routes", dataProvider = "flightRoutes", dataProviderClass = FlightData.class)
	public void searchFlights(FlightRoute route) {
		log.info("Starting flight search test");
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
