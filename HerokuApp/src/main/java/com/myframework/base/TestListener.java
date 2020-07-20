package com.myframework.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	Logger log;
	String testName;
	String testMethodName;
	String testSuiteName;

	@Override
	public void onTestStart(ITestResult result) {
		this.testMethodName = result.getMethod().getMethodName();
		log.info("[Starting " + testMethodName + " ]");
	}
	// TODO Auto-generated method stub

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("[Test " + testMethodName + " passed " + "]");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("[Test " + testMethodName + " failed " + "]");
		WebDriver driver = ((BaseTest) result.getInstance()).driver;
		takeScreenshot(driver, testName);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("[Test " + testMethodName + " Skipped " + "]");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		this.testName = context.getCurrentXmlTest().getName();
		this.testSuiteName = context.getSuite().getName();
		this.log = LogManager.getLogger(testName);
		log.info("[Test" + testName + "STARTED ]");

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		log.info("[Test" + testName + "FINISHED ]");

	}

	/** Take screenshot */
	protected void takeScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Call method to capture screenshot
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "screenshots"
				+ File.separator + getTodaysDate() + File.separator + testSuiteName + File.separator + testName
				+ File.separator + testMethodName + File.separator + getSystemTime() + " " + fileName + ".png";

		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Todays date in yyyyMMdd format */
	private static String getTodaysDate() {
		return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}

	/** Current time in HHmmssSSS */
	private String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}

}
