package com.aerotestx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage {

	private WebDriver driver; 
	
	private By depatureCity = By.name("fromPort");
	
	private By destinationCity = By.name("toPort");
	
	private By submit = By.cssSelector("input[value='Find Flights']");
	
	public FlightSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectDepatureCity(String city) {
		Select depature = new Select(driver.findElement(depatureCity));
		
		depature.selectByVisibleText(city);
	}
	
	public void selectDestiantionCity(String city) {
		Select depature = new Select(driver.findElement(destinationCity));
		
		depature.selectByVisibleText(city);
	}
	
	public void FindFlights() {
		
		driver.findElement(submit).click();;
		
		
	}
	
}
