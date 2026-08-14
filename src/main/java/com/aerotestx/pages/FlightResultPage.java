package com.aerotestx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightResultPage {

	private WebDriver driver; 
	
	private By resultHeading = By.tagName("h3");

	public FlightResultPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getResultHeading() {
		String heading =  driver.findElement(resultHeading).getText();
		return heading;
	}
	public boolean isFlightResultsDisplayed() {

        return driver.findElement(resultHeading).isDisplayed();
    }
}
