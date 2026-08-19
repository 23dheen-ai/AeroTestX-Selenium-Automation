package com.aerotestx.base;

import java.time.Duration;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aerotestx.factory.DriverFactory;
import com.aerotestx.utils.ConfigReader;
import com.aerotestx.utils.LogUtils;

public abstract class BaseTest {
	



	private static final Logger log =
	        LogUtils.getLogger(BaseTest.class);
	
	@BeforeMethod
	public void setUp() {

		log.info("Starting test setup");
		
		String browser =System.getProperty("browser",ConfigReader.getProperty("browser"));
		
		DriverFactory.initializeDriver(browser);
		Long implicitWait = Long.parseLong(ConfigReader.getProperty("implicitWait"));
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		
		log.info("Browser initialized successfully");
		String url = ConfigReader.getProperty("url");
		DriverFactory.getDriver().get(url);
		
	}

	@AfterMethod
	public void tearDown() {
		log.info("Starting browser cleanup");
		
		DriverFactory.unload();
		log.info("Browser closed successfully");
	}

	public WebDriver getDriver() {
		 return DriverFactory.getDriver();
	}
}
