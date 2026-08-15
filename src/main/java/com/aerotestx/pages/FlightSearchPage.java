package com.aerotestx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aerotestx.utils.WaitUtils;

public class FlightSearchPage {

	private WebDriver driver;
	private WaitUtils wait;
	
	private By departureCity = By.name("fromPort");
	
	private By destinationCity = By.name("toPort");
	
	private By submit = By.cssSelector("input[value='Find Flights']");
	
	public FlightSearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}

	public void selectDepatureCity(String city) {
		Select depature = new Select(wait.waitForVisibility(departureCity));
		
		depature.selectByVisibleText(city);
	}
	
	public void selectDestiantionCity(String city) {
		Select depature = new Select(wait.waitForVisibility(destinationCity));
		
		depature.selectByVisibleText(city);
	}
	
	public void FindFlights() {
		
		wait.waitForClickable(submit).click();;
		
		
	}
	
}
