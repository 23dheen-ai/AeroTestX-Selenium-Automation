package com.aerotestx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aerotestx.utils.WaitUtils;

public class ConfirmationPage {

	private WebDriver driver;
	private WaitUtils wait;

    private By confirmationHeading =
            By.tagName("h1");
    
    private By confirmationTable =
            By.cssSelector("table");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }
    
    public String getConfirmation() {
    	return driver.findElement(confirmationHeading).getText();
    }
    
    public String getBookingId() {

        return getTableValue("Id");
    }

    public String getStatus() {

        return getTableValue("Status");
    }

    public String getAmount() {

        return getTableValue("Amount");
    }

    private String getTableValue(String label) {

        return driver.findElement(
                By.xpath(
                    "//table//td[normalize-space()='"
                    + label
                    + "']/following-sibling::td[1]"
                )
        ).getText();
    }

    public boolean isConfirmationDisplayed() {

        return wait
                .waitForVisibility(
                confirmationTable
        ).isDisplayed();
    }
}
