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
		 
		 String directory = "screenshots";
		 
		 
		 String fileName = testName +"_"+timeStamp+".png";
		 
		 Path path = Paths.get(directory,fileName);
		 
		 try {
			 Files.createDirectories(Paths.get(directory));
			 
			 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 
			 Files.copy(source.toPath(), path);
			 
			 System.out.println(
	                    "Screenshot saved: "
	                    + path);
	     return path.toString();

			
		} catch (IOException e) {
			throw new RuntimeException("Failed to capute screenshot", e);
		}
		 
	 }
}
