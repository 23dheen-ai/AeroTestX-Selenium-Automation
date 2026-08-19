package com.aerotestx.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extent;

	public static ExtentReports getExtentReports() {
		if (extent == null) {
			String reportPath = System.getProperty("user.dir") + "/target/extent-report/AeroTestX-Report.html";

			ExtentSparkReporter spartReport = new ExtentSparkReporter(reportPath);

			spartReport.config().setDocumentTitle("AeroTestX Automation Report");

			spartReport.config().setReportName("AeroTestX Test Execution");

			extent = new ExtentReports();

			extent.attachReporter(spartReport);
			extent.setSystemInfo(
			        "Browser",
			        System.getProperty("browser"));

			extent.setSystemInfo("Framework", "AeroTestX");

			extent.setSystemInfo("Automation", "Selenium + Java + TestNG");

		}
		return extent;

	}
}
