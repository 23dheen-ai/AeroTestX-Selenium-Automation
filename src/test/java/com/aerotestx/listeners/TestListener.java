package com.aerotestx.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aerotestx.factory.DriverFactory;

import com.aerotestx.utils.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

//	private static final Logger log = LogUtils.getLogger(TestListener.class);
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onTestStart(ITestResult result) {

		ITestListener.super.onTestStart(result);
		ExtentTest test = ExtentManager.getExtentReports().createTest(result.getMethod().getMethodName());

		extentTest.set(test);
		String browser = System.getProperty("browser");

		extentTest.get().info("Browser: " + browser);
		extentTest.get().log(Status.INFO, "Test Started");

//		log.info("TEST STARTED: {}", result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ITestListener.super.onTestSuccess(result);

//		log.info("TEST PASSED: {}", result.getMethod().getMethodName());
		extentTest.get().log(Status.INFO, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		ITestListener.super.onTestFailure(result);
		extentTest.get().log(Status.INFO, "Test Failed");
		WebDriver driver = DriverFactory.getDriver();
		if (driver != null) {
			try {
				String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
				extentTest.get().addScreenCaptureFromBase64String(screenshot, "Failure Screenshot");

			} catch (Exception e) {
				extentTest.get().log(Status.WARNING, "Screenshot could not be captured");
			}
		}

//		Object instance = result.getInstance();
//		WebDriver driver = ((BaseTest) instance).getDriver();
//
//		String testName = result.getMethod().getMethodName();
//		ScreenshotUtils.captureScreenshot(driver, testName);

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ITestListener.super.onTestSkipped(result);
//		log.warn("TEST SKIPPED: {}", result.getMethod().getMethodName());
		extentTest.get().log(Status.INFO, "Test Skipped");
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
		ExtentManager.getExtentReports().flush();
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
