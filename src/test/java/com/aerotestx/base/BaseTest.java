package com.aerotestx.base;

import java.time.Duration;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aerotestx.factory.DriverFactory;
import com.aerotestx.utils.ConfigReader;
import com.aerotestx.utils.LogUtils;

public abstract class BaseTest {

	protected WebDriver driver;

	private static final Logger log =
	        LogUtils.getLogger(BaseTest.class);
	
	@BeforeMethod
	public void setUp() {

		log.info("Starting test setup");

		String browser = System.getProperty("browser", ConfigReader.getProperty("browser"));

		String url = ConfigReader.getProperty("url");

		Long implicitWait = Long.parseLong(ConfigReader.getProperty("implicitWait"));
		driver = DriverFactory.createDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		
		log.info("Browser initialized successfully");
		
		driver.get(url);
		
	}

	@AfterMethod
	public void tearDown() {
		log.info("Starting browser cleanup");
		
		if (driver != null) {
			driver.quit();
		}
		log.info("Browser closed successfully");
	}

	public WebDriver getDriver() {
		return driver;
	}
}
