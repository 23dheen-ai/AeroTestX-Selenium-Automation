package com.aerotestx.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aerotestx.base.BaseTest;

public class BaseTestDemoTest extends BaseTest{

	@Test
	public void verifyGoogleTitle() {
		String Actual = driver.getTitle();
		
		System.out.println("Actual Title: " +Actual);
		Assert.assertEquals(Actual, "Google"); 
	}

	
}
