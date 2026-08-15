package com.aerotestx.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aerotestx.factory.DriverFactory;
import com.aerotestx.utils.ConfigReader;

public abstract class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {

		String browser = System.getProperty("browser", ConfigReader.getProperty("browser"));

		String url = ConfigReader.getProperty("url");

		Long implicitWait = Long.parseLong(ConfigReader.getProperty("implicitWait"));
		driver = DriverFactory.createDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

		driver.get(url);

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
}
