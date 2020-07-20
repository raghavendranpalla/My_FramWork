package com.myframework.base;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListenersExtent implements ITestListener {
	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
		extentTest.set(test);

		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String logText = "<b>TestMethod" + result.getMethod().getMethodName() + "Successful	</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, markup);
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>" + "Exception Occured, click to see the details:"
				+ "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");

		WebDriver driver = ((BaseTest) result.getInstance()).driver;
		String path = takeScreenshot(driver, result.getMethod().getMethodName());
		try {
			extentTest.get().fail("<b><font colot=red>" + "Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());

		} catch (Exception e) {
			extentTest.get().fail("Test Failed cannot Attach ScreenShot");
		}
		String logTest = "<b>Test Method " + methodName +Arrays.toString(result.getParameters())+  "Failed</b>";
		Markup markup = MarkupHelper.createLabel(logTest, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, markup);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String logText = "<b>TestMethod" + result.getMethod().getMethodName() + "Skipped</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, markup);
		// TODO Auto-generated method stub

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

	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();

		}
		// TODO Auto-generated method stub

	}

	public String takeScreenshot(WebDriver driver, String methodName) {
		String filename = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdirs();
		String path = directory + filename;
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("*********************************************");
			System.out.println("Screenshot Stored at " + path);
			System.out.println("*********************************************");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return path;
	}

	public static String getScreenshotName(String methodName) {
		Date date = new Date();
		String filename = methodName + "_" + date.toString().replace(":", "_").replace(":", "_") + ".png";
		return filename;
	}

}
