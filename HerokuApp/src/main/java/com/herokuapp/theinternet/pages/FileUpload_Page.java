package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUpload_Page extends BasePage {

	public FileUpload_Page(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	private By fileUpload = By.xpath("//h1[contains(text(),'FILE UPLOAD')]");
	private By submit = By.xpath("//input[@type='submit']");
	private By fileinput = By.xpath("//input[@type='file']");
	private String sucesstext;

	public FileUpload_Page openfileUpload_page() {
		click(fileUpload);
		switchToWindow("File Upload");
		return new FileUpload_Page(driver, log);
	}

	public String emptyfileuploadAlert_text() {

		click(submit);

		return switchToAlert().getText();

	}

	public String Expected_emptyfileAlerttext() {
		return "You need to select a file to upload!";
	}

	public String uploadfile( ) {

		text(fileinput,
				"C:\\Users\\91958\\eclipse-workspace\\HerokuApp\\src\\main\\resources\\files\\Raghavendranpalla Updated Resume.pdf");
		click(submit);
		sucesstext = switchToAlert().getText();
		
		System.out.println(sucesstext);

		return switchToAlert().getText();
	}

	public String actualSucessText() {
		return sucesstext;
	}

	public String expectedSucessText() {
		return "Your file has now been uploaded!";
	}

}
