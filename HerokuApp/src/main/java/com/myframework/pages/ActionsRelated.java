package com.myframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsRelated extends BasePage {
	By actions = By.xpath("//h1[contains(text(),'ACTIONS')]");
	By drag = By.xpath("//b[contains(text(),'DRAG ME TO MY TARGET!')]");
	By drop = By.xpath("//div[@id='droppable']");

	public ActionsRelated(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public ActionsRelated openActionsPage() {
		click(actions);
		switchToWindow("WebDriver | Actions");
		return new ActionsRelated(driver, log);
	}

	public void testDragAndDrop() {
		performDragAndDrop(drag, drop);

	}

	public String actualReturnDropText() {
		return find(drop).getText();

	}

	public String expectedDropText() {
		return "Dropped!";
	}

}
