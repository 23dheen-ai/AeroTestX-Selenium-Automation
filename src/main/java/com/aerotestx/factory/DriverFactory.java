package com.aerotestx.factory;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aerotestx.utils.LogUtils;

public class DriverFactory {

	private static final Logger log =
	        LogUtils.getLogger(DriverFactory.class);
	
	public static WebDriver createDriver(String browser) {

		log.info(
			    "Initializing browser: {}",
			    browser
			);
        if (browser == null || browser.isBlank()) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {

        case "chrome":
            return new ChromeDriver();

        case "firefox":
            return new FirefoxDriver();

        case "edge":
            return new EdgeDriver();

        default:
            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
        }
        
    }
	
}
