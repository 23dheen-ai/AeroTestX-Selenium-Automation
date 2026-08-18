package com.aerotestx.listeners;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aerotestx.base.BaseTest;
import com.aerotestx.pages.FlightSearchPage;
import com.aerotestx.utils.LogUtils;
import com.aerotestx.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

	private static final Logger log = LogUtils.getLogger(TestListener.class);
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		ITestListener.super.onTestStart(result);
		
		log.info(
		        "TEST STARTED: {}",
		        result.getMethod().getMethodName()
		    );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		ITestListener.super.onTestSuccess(result);
		
		log.info(
		        "TEST PASSED: {}",
		        result.getMethod().getMethodName()
		    );
	}

	@Override
	public void onTestFailure(ITestResult result) {

		ITestListener.super.onTestFailure(result);

		Object instance = result.getInstance();
		WebDriver driver = ((BaseTest) instance).getDriver();

		String testName = result.getMethod().getMethodName();
		ScreenshotUtils.captureScreenshot(driver, testName);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);
		log.warn(
		        "TEST SKIPPED: {}",
		        result.getMethod().getMethodName()
		    );
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}
