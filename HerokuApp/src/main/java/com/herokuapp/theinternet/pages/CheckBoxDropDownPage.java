package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckBoxDropDownPage extends BasePage {

	private By checkBoxList = By.xpath("//div[@class='section-title']//input[@type='checkbox']");
	private By opencheckBoxDropdownPage = By.xpath("//h1[contains(text(),'DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)')]");
	private By dropdownTools = By.id("dropdowm-menu-2");
	private By forntEnd = By.id("dropdowm-menu-3");
	private By dropDownLanguages = By.id("dropdowm-menu-1");

	public CheckBoxDropDownPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public CheckBoxDropDownPage openCheckBoxPage() {
		click(opencheckBoxDropdownPage);
		switchToWindow("WebDriver | Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)");
		return new CheckBoxDropDownPage(driver, log);
	}

	public void selectUncheckedChekBox() {

		List<WebElement> checkBoxs = findElements(checkBoxList);
		System.out.println(checkBoxs.size());
		for (WebElement checkBox : checkBoxs) {
			if (!checkBox.isSelected()) {
				checkBox.click();

			}

		}
	}

	public boolean areAllckeckBoxsSelected() {
		List<WebElement> checkBoxs = findElements(checkBoxList);
		for (WebElement checkBox : checkBoxs) {
			if (!checkBox.isSelected()) {
				return false;
			}
		}
		return true;
	}

	public void selectGivenRadioButton(String enterTheNameToBeSelected) {

		By radioButton = By.xpath("//input[@type='radio'and @value='" + enterTheNameToBeSelected + "']");
		click(radioButton);

	}

	public boolean isGivenRadioButtonSelected(String enterTheNameToBeSelected) {
		By radioButton = By.xpath("//input[@type='radio'and @value='" + enterTheNameToBeSelected + "']");
		WebElement radioButtonElement = find(radioButton);
		if (!radioButtonElement.isSelected()) {
			return false;

		}

		return true;
	}

	public void selectGivenTextinTools(String text) {
		WebElement element = find(dropdownTools);
		Select toolsSelect = new Select(element);
		toolsSelect.selectByVisibleText(text);

	}

	public void selectGivenindex(int i) {
		WebElement element = find(forntEnd);
		Select toolsSelect = new Select(element);
		toolsSelect.selectByIndex(i);

	}

	public String selectGetSelectedTextFormDropDownlan() {
		WebElement element = find(dropDownLanguages);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();

	}

	public String selectGetSelectedTextFormDropDownfro() {
		WebElement element = find(forntEnd);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();

	}

	public String selectGetSelectedTextFormDropDown() {
		WebElement element = find(dropdownTools);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();

	}

	public void selectUsingValueOfLanguage(String value) {
		WebElement element = find(dropDownLanguages);
		Select language = new Select(element);
		language.selectByValue(value);
	}

	public void selectAllDropDowns(String text,String value,int i) {
		selectGivenTextinTools(text);
		selectUsingValueOfLanguage(value);
		selectGivenindex(i);
	}
}
