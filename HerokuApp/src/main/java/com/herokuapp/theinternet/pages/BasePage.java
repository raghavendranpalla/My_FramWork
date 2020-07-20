package com.herokuapp.theinternet.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected Logger log;

	public BasePage(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	protected void navigateTo(String url) {
		driver.navigate().to(url);

	}

	protected void performDragAndDrop(By from, By to) {
		waitForVisibility(from, 5);
		waitForVisibility(to, 5);
		Actions actions = new Actions(driver);
		actions.dragAndDrop(find(from), find(to)).build().perform();
	}

	protected void clickUsingActions(By locator) {
		waitForVisibility(locator, 5);
		WebElement element = find(locator);
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}

	protected void pressKeys(By locator, Keys keys) {
		find(locator).sendKeys(keys);
	}

	protected List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	protected void click(By locator) {
		waitForVisibility(locator, 5);
		find(locator).click();
	}

	protected void openUrl(By locator, String url) {
		driver.get(url);
	}

	protected void text(By locator, String text) {
		waitForVisibility(locator, 5);
		find(locator).sendKeys(text);
	}

	private void waitfor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {

		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);

	}

	protected void waitForVisibility(By locator, Integer... timeOutInSeconds) {

		int count = 0;
		while (count < 2) {
			try {
				waitfor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length < 0 ? timeOutInSeconds[0] : null));

			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}
			count++;
		}

	}

	protected String getPageTitle() {
		return driver.getTitle();
	}

	protected String getText(By locator) {
		waitForVisibility(locator, 5);
		return find(locator).getText();
	}

	protected Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}

	protected void switchToWindow(String expectedtitle) {

		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (Iterator<String> iterator = allWindows.iterator(); iterator.hasNext();) {
			String movingWindows = (String) iterator.next();

			if (!movingWindows.equals(mainWindow)) {
				driver.switchTo().window(movingWindows);
				if (getPageTitle().equals(expectedtitle)) {
					break;

				}

			}

		}
	}

	protected void JS_clickUsingID(String id) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("document.getElementById(\"" + id + "\").click();");
	}

}
