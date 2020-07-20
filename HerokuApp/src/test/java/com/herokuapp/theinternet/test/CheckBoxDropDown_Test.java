package com.herokuapp.theinternet.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.CheckBoxDropDownPage;

public class CheckBoxDropDown_Test extends BaseTest {

	@Test(priority = 0, groups = { "stable" })
	public void selectUncheckedChekbox() {

		CheckBoxDropDownPage boxDropDownPage = new CheckBoxDropDownPage(driver, log);
		boxDropDownPage.openCheckBoxPage().selectUncheckedChekBox();
		Assert.assertTrue(boxDropDownPage.areAllckeckBoxsSelected(), "some Check Boxs are not selected");

	}

	@Test(priority = 1, groups = { "stable" })
	public void selectRadiobutton() {

		CheckBoxDropDownPage boxDropDownPage = new CheckBoxDropDownPage(driver, log);
		boxDropDownPage.openCheckBoxPage().selectGivenRadioButton("blue");
		Assert.assertTrue(boxDropDownPage.isGivenRadioButtonSelected("blue"), "Given Radio Button Was Not Selected");

	}

	@Test(priority = 2, groups = { "stable" })
	public void selectDropDownUsignVisibleText() {
		CheckBoxDropDownPage boxDropDownPage = new CheckBoxDropDownPage(driver, log);
		boxDropDownPage.openCheckBoxPage().selectGivenTextinTools("TestNG");
		Assert.assertEquals(boxDropDownPage.selectGetSelectedTextFormDropDown(), "TestNG");

	}

	@Test(priority = 3, groups = { "stable" })
	public void selectDropDownUsignValue() {
		CheckBoxDropDownPage boxDropDownPage = new CheckBoxDropDownPage(driver, log);
		boxDropDownPage.openCheckBoxPage().selectUsingValueOfLanguage("java");
		Assert.assertEquals(boxDropDownPage.selectGetSelectedTextFormDropDownlan(), "JAVA");
		

	}
	
	@Test(priority = 4, groups = { "stable" })
	public void selectDropDownUsignindex() {
		CheckBoxDropDownPage boxDropDownPage = new CheckBoxDropDownPage(driver, log);
		boxDropDownPage.openCheckBoxPage().selectGivenindex(3);
		Assert.assertEquals(boxDropDownPage.selectGetSelectedTextFormDropDownfro(), "JQuery");
		

	}
	@Test(priority = 5, groups = { "stable" })
	public void selectAllDropDowns() {
		CheckBoxDropDownPage boxDropDownPage = new CheckBoxDropDownPage(driver, log);
		boxDropDownPage.openCheckBoxPage().selectAllDropDowns("Maven", "sql", 0);

		Assert.assertEquals(boxDropDownPage.selectGetSelectedTextFormDropDownfro(), "HTML");
		Assert.assertEquals(boxDropDownPage.selectGetSelectedTextFormDropDown(), "Maven");
		Assert.assertEquals(boxDropDownPage.selectGetSelectedTextFormDropDownlan(), "SQL");
		

	}


}
