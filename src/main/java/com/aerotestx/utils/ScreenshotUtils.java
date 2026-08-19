package com.aerotestx.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	private ScreenshotUtils() {
		
	}
	
	 public static String captureScreenshot(WebDriver driver,String testName) {
		 String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmSS").format(new Date());
		 
		 try {

	            Path screenshotDirectory =
	                    Path.of(
	                            System.getProperty("user.dir"),
	                            "target",
	                            "screenshots"
	                    );

	            Files.createDirectories(
	                    screenshotDirectory
	            );

	            File source =
	                    ((TakesScreenshot) driver)
	                            .getScreenshotAs(
	                                    OutputType.FILE
	                            );

	            Path destination =
	                    screenshotDirectory.resolve(
	                            testName + timeStamp+".png"
	                    );

	            Files.copy(
	                    source.toPath(),
	                    destination
	            );

	            return destination.toString();

	        } catch (IOException e) {

	            throw new RuntimeException(
	                    "Unable to capture screenshot",
	                    e
	            );
	        }
		 
	 }
}
