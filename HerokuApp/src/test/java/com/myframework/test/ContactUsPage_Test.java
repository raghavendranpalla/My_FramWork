package com.myframework.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myframework.base.BaseTest;
import com.myframework.base.CsvDataProviders;
import com.myframework.pages.ContactUsPage;

public class ContactUsPage_Test extends BaseTest {

	@Test(priority = 0, groups = { "stable" })
	public void open_CheckTitle_ContactUsPage() {
		ContactUsPage contactUsPage = new ContactUsPage(driver, log);
		contactUsPage.openContactus();

		Assert.assertEquals(contactUsPage.actualTitle(), contactUsPage.expectedTitle());
	}

	@Test(priority = 1, dataProvider = "contactusform" , dataProviderClass = CsvDataProviders.class, groups = {
			"stable" })
	public void fill_form(Map<String, String> testData) {
		String firstname = testData.get("firstname");
		String lastname = testData.get("lastname");
		String email = testData.get("email");
		String comments = testData.get("comments");
		String expectedThanksText = testData.get("thanks");
		ContactUsPage contactUsPagee = new ContactUsPage(driver, log);
		contactUsPagee.openContactus().fill_the_form(firstname, lastname, email, comments);

		Assert.assertTrue((contactUsPagee.actual_thanks_text()).contains(expectedThanksText));
	}

}
