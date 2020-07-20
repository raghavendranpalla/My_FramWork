package com.myframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

	private By contactUs = By.xpath("//div//H1[text()='CONTACT US']");
	private By firstName = By.xpath("//input[@name='first_name']");
	private By lastName = By.xpath("//input[@name='last_name']");
	private By emaillo = By.xpath("//input[@name='email']");
	private By commentslo = By.xpath("//textarea[@name='message']");
	private By thankyou = By.xpath("//h1[contains(text(),'Thank You for your Message!')]");
	private By submit = By.xpath("//input[@value='SUBMIT']");

	public ContactUsPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public ContactUsPage openContactus() {
		click(contactUs);
		switchToWindow("WebDriver | Contact Us");
		return new ContactUsPage(driver, log);

	}

	public String actualTitle() {
		return getPageTitle();
	}

	public String expectedTitle() {
		return "WebDriver | Contact Us";
	}

	public ContactUsPage fill_the_form(String firstname, String lastname, String email, String comments) {

		text(firstName, firstname);
		text(lastName, lastname);
		text(emaillo, email);
		text(commentslo, comments);
		click(submit);

		return new ContactUsPage(driver, log);

	}

	public String actual_thanks_text() {
		return getText(thankyou);
		
		
	}

	public String expected_Thankyou_text() {
		return "Thank You for your Message!";
	}
}
