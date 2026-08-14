package com.aerotestx.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aerotestx.base.BaseTest;
import com.aerotestx.pages.FlightResultPage;
import com.aerotestx.pages.FlightSearchPage;

public class FlightSearchTest extends BaseTest{

	@Test
	public void searchFlights() {
		
		FlightSearchPage searchPage = new FlightSearchPage(driver);
		
		searchPage.selectDepatureCity("Boston");
		searchPage.selectDestiantionCity("New York");
		searchPage.FindFlights();
		
		FlightResultPage results = new FlightResultPage(driver);
		
		Assert.assertTrue(results.isFlightResultsDisplayed(), "Flight results page was not displayed");
	}
	
}
