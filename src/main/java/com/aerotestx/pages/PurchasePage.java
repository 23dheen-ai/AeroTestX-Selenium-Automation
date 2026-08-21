package com.aerotestx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aerotestx.models.Passenger;
import com.aerotestx.utils.WaitUtils;

public class PurchasePage {

	private WebDriver driver;
	private WaitUtils wait;
	
	private By name =
            By.id("inputName");

    private By address =
            By.id("address");

    private By city =
            By.id("city");

    private By state =
            By.id("state");

    private By zipCode =
            By.id("zipCode");

    private By cardType =
            By.id("cardType");

    private By creditCardNumber =
            By.id("creditCardNumber");

    private By creditCardMonth =
            By.id("creditCardMonth");

    private By creditCardYear =
            By.id("creditCardYear");

    private By nameOnCard =
            By.id("nameOnCard");

    private By purchaseButton =
            By.cssSelector("input[type='submit']");

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}
	
	public PurchasePage enterName(String value) {
		wait.waitForVisibility(name).sendKeys(value);
		return this;
	}
	
	public PurchasePage enterAddress(String value) {
		wait.waitForVisibility(address).sendKeys(value);
		return this;
	}
	
	public PurchasePage enterCity(String value) {
		wait.waitForVisibility(city).sendKeys(value);
		return this;
	}
	
	public PurchasePage enterState(String value) {
		wait.waitForVisibility(state).sendKeys(value);
		return this;
	}
	
	public PurchasePage enterZipCode(String value) {
		wait.waitForVisibility(zipCode).sendKeys(value);
		return this;
	}
	
	public PurchasePage cardType(String value) {
		
		Select card = new Select(driver.findElement(cardType));
		card.selectByVisibleText(value);
		return this;
	}
	
	public PurchasePage creditCardNumber(String value) {
		wait.waitForVisibility(creditCardNumber).sendKeys(value);
		return this;
	}
    
	public PurchasePage creditCardMonth(String value) {
		wait.waitForVisibility(creditCardMonth).clear();
		wait.waitForVisibility(creditCardMonth).sendKeys(value);
		return this;
	}
	public PurchasePage creditCardYear(String value) {
		wait.waitForVisibility( creditCardYear).clear();
		wait.waitForVisibility(creditCardYear).sendKeys(value);
		return this;
	}
	public PurchasePage nameOnCard(String value) {
		wait.waitForVisibility(nameOnCard).sendKeys(value);
		return this;
	}
	public PurchasePage purchaseButton() {
		driver.findElement(purchaseButton).click();
		return this;
	}
	
	public PurchasePage fillPassengerDetails(Passenger passenger) {
		enterName(passenger.getName());

	    enterAddress(passenger.getAddress());

	    enterCity(passenger.getCity());

	    enterState(passenger.getState());

	    enterZipCode(passenger.getZipCode());

	    cardType(passenger.getCardType());

	    creditCardNumber(
	            passenger.getCardNumber()
	    );

	    creditCardMonth(
	            passenger.getCardMonth()
	    );

	    creditCardYear(
	            passenger.getCardYear()
	    );

	    nameOnCard(
	            passenger.getNameOnCard()
	    );

	    return this;
	}

    
	
}
