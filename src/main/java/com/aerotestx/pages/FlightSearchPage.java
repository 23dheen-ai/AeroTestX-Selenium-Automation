package com.aerotestx.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aerotestx.utils.LogUtils;
import com.aerotestx.utils.WaitUtils;

public class FlightSearchPage {

	private WebDriver driver;
	private WaitUtils wait;
	private static final Logger log = LogUtils.getLogger(FlightSearchPage.class);

	private By departureCity = By.name("fromPort");

	private By destinationCity = By.name("toPort");

	private By submit = By.cssSelector("input[value='Find Flights']");

	public FlightSearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}

	public FlightSearchPage selectDepatureCity(String city) {
		log.info("Selecting departure city: {}", city);

		Select depature = new Select(wait.waitForVisibility(departureCity));

		depature.selectByVisibleText(city);
		return this;
	}

	public FlightSearchPage selectDestiantionCity(String city) {

		log.info("Selecting destination city: {}", city);
		Select depature = new Select(wait.waitForVisibility(destinationCity));

		depature.selectByVisibleText(city);
		return this;
	}

	public FlightResultPage FindFlights() {
		log.info("Clicking flight search button");

		wait.waitForClickable(submit).click();
		return new FlightResultPage(driver);

	}
	public List<WebElement> getDepatureLocations() {
		log.info("Getting departure Locations:");

		Select depature = new Select(wait.waitForVisibility(departureCity));

		List<WebElement> fromCities = depature.getOptions();

        return fromCities;
	}
	
	public List<WebElement> getDestiantionLocations() {

		log.info("Getting destination Locations:");
		Select depature = new Select(wait.waitForVisibility(destinationCity));

		List<WebElement> toCities = depature.getOptions();

        return toCities;
	}

}
