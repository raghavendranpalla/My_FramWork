package com.myframework.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myframework.base.BaseTest;
import com.myframework.pages.FileUpload_Page;

public class FileUpload_Test extends BaseTest {

	@Test(priority = 0,groups = {  "stable" })
	public void fileUpload_NegativeTest() {
		FileUpload_Page fpage = new FileUpload_Page(driver, log);
		fpage.openfileUpload_page();
		Assert.assertEquals(fpage.emptyfileuploadAlert_text(), fpage.Expected_emptyfileAlerttext());
	}

	@Test(priority = 1,groups = {  "stable" })
	public void fileUpload_PositiveTest() {
		FileUpload_Page fpage = new FileUpload_Page(driver, log);
		Assert.assertEquals(fpage.openfileUpload_page().uploadfile(), fpage.expectedSucessText());

	}

}
