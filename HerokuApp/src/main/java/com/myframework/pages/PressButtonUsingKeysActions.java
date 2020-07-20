package com.myframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PressButtonUsingKeysActions extends BasePage {
	private By buttonforKeys = By.xpath("//p[contains(text(),'CLICK ME!')]");
	private String urlOfButtonPage = "http://www.webdriveruniversity.com/Click-Buttons/index.html";
	private By closeButton1 = By
			.xpath("//div[@id='myModalClick']//button[@class='btn btn-default'][contains(text(),'Close')]");

	private By button3 = By.xpath("//span[@id='button3']");
	private String button2Id = "button2";
	private By button2ID = By.id("button2");

	public PressButtonUsingKeysActions(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void pressButtonUsingKeys() {
		navigateTo(urlOfButtonPage);
		find(buttonforKeys).click();
		find(closeButton1).click();

	}

	public void clickUsingJSExe() {
		navigateTo(urlOfButtonPage);
		waitForVisibility(button2ID, 5);
		JS_clickUsingID(button2Id);
	}

	public void clickUsingAct() {
		navigateTo(urlOfButtonPage);
		clickUsingActions(button3);

	}
}
