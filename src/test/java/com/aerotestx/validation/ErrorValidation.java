package com.aerotestx.validation;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aerotestx.base.BaseTest;
import com.aerotestx.data.FlightData;
import com.aerotestx.data.FlightRoute;
import com.aerotestx.pages.FlightSearchPage;
import com.aerotestx.tests.FlightSearchTest;
import com.aerotestx.utils.LogUtils;

public class ErrorValidation extends BaseTest{
	private static final Logger log = LogUtils.getLogger(FlightSearchTest.class);

	@Test(description = "Searching flights for invalid location and validate it",
			dataProvider = "validateRoutes", dataProviderClass = FlightData.class, priority = 1)
	public void validationTest(FlightRoute route) {
		log.info("Starting flight search test");
		FlightSearchPage searchPage = new FlightSearchPage(getDriver());
		// System.out.println("Searching: " + from + " -> " + to);
		searchPage.selectDepatureCity(route.getFrom());
		searchPage.selectDestiantionCity(route.getTO());
		searchPage.FindFlights();
	}
	
	@Test(description = "Getting available airport locations to validate",priority = 2)
	public void getAvailableRoutes() {
		
		FlightSearchPage searchPage = new FlightSearchPage(getDriver());
		
		List<WebElement>fromCities = searchPage.getDepatureLocations();
		for (WebElement option : fromCities) {
            System.out.println(option.getText());
        }
		
		List<WebElement>toCities = searchPage.getDestiantionLocations();
		for (WebElement option : toCities) {
            System.out.println(option.getText());
        }
	}
}
