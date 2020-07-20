package com.myframework.base;

import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class TestUtilities extends BaseTest {

	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** Take screenshot */
	/*
	 * protected void takeScreenshot(String fileName,WebDriver driver) { File
	 * scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); String
	 * path = System.getProperty("user.dir") + File.separator + "test-output" +
	 * File.separator + "screenshots" + File.separator + getTodaysDate() +
	 * File.separator + testSuiteName + File.separator + testName + File.separator +
	 * testMethodName + File.separator + getSystemTime() + " " + fileName + ".png";
	 * try { FileUtils.copyFile(scrFile, new File(path)); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 * 
	 *//** Todays date in yyyyMMdd format */
	/*
	 * private static String getTodaysDate() { return (new
	 * SimpleDateFormat("yyyyMMdd").format(new Date())); }
	 * 
	 *//** Current time in HHmmssSSS *//*
										 * private String getSystemTime() { return (new
										 * SimpleDateFormat("HHmmssSSS").format(new Date())); }
										 */
}
