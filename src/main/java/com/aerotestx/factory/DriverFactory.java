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
	private static final ThreadLocal<WebDriver>
    driver = new ThreadLocal<>();
	
	public static WebDriver initializeDriver(String browser) {

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "chrome":
                webDriver = new ChromeDriver();
                break;

            case "firefox":
                webDriver = new FirefoxDriver();
                break;

            case "edge":
                webDriver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid browser: " + browser
                );
        }

        driver.set(webDriver);
		return webDriver;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void unload() {

        WebDriver webDriver = driver.get();

        if (webDriver != null) {
            webDriver.quit();
        }

        driver.remove();
    }
        
    }
	

