package com.aerotestx.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public WebDriver driver;
	public WebDriverWait wait;
	public WaitUtils(WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
	}
	
	public WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public boolean waitForElementPresent(By locator) {

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        locator
                )
        ) != null;
    }

    public boolean waitForTitle(String title) {

        return wait.until(
                ExpectedConditions.titleContains(title)
        );
    }

    public void waitForUrl(String url) {

        wait.until(
                ExpectedConditions.urlContains(url)
        );
}}
