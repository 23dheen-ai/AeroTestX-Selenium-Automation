package com.aerotestx.pages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aerotestx.models.Flight;
import com.aerotestx.utils.WaitUtils;

public class FlightResultPage {

	private WebDriver driver;
	private WaitUtils wait;

	private By flightRows = By.cssSelector("table tbody tr");

	private By resultHeading = By.tagName("h3");

	public FlightResultPage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}

	public String getResultHeading() {
		String heading = driver.findElement(resultHeading).getText();
		return heading;
	}

	public boolean isFlightResultsDisplayed() {

		return wait
		        .waitForVisibility(resultHeading).isDisplayed();
	}

	public List<Flight> getAvailableFlights() {
		
		wait.waitForElementPresent(flightRows);

		List<Flight> flights = new ArrayList<>();

		List<WebElement> rows = driver.findElements(flightRows);

		for (WebElement row : rows) {

			List<WebElement> columns = row.findElements(By.tagName("td"));

			String flightNumber = columns.get(1).getText();

			String airLine = columns.get(2).getText();

			String priceText = columns.get(5).getText();

			double price = Double.parseDouble(priceText.replace("$", "").replace(",", "").trim());
			Flight flight = new Flight(airLine, flightNumber, price);

			flights.add(flight);
		}
		return flights;
		
	}
	

	public Flight getCheapestFlight() {

		return getAvailableFlights().stream().min(Comparator.comparingDouble(Flight::getPrice))
				.orElseThrow(() -> new RuntimeException("No flights available"));
	}

	public void selectFlight(Flight selectedFlight) {

		List<WebElement> rows = driver.findElements(flightRows);

		for (WebElement row : rows) {

			List<WebElement> columns = row.findElements(By.tagName("td"));

			String flightNumber = columns.get(1).getText();

			String airLine = columns.get(2).getText();

			String priceText = columns.get(5).getText();

			double price = Double.parseDouble(priceText.replace("$", "").replace(",", "").trim());

			if (airLine.equals(selectedFlight.getAirline()) && flightNumber.equals(selectedFlight.getFlightNumber())
					&& Double.compare(price, selectedFlight.getPrice()) == 0) {

				row.findElement(By.cssSelector("input[type='submit']")).click();

				return;
			}
		}

		throw new RuntimeException("Selected flight was not found");
	}
}
