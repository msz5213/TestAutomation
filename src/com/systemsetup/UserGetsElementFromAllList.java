package com.systemsetup;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserGetsElementFromAllList extends BaseTest {

	/*
	 * public UserVerifiesElement(WebDriver driver) { super(driver); // TODO
	 * Auto-generated constructor stub }
	 */

	WebElement allDropDown;
	Select allDropdownList;
	List<String> departmentsFromDropdown = new ArrayList<String>();

	//public void getDropDownList() {
	public List<String> getDropDownList() {

		allDropDown = driver.findElement(By.id("searchDropdownBox"));
		allDropdownList = new Select(allDropDown);

		List<WebElement> elementsInAllDropDownList = allDropdownList.getOptions();
		for (int i = 0; i < elementsInAllDropDownList.size(); i++) {
			if (allDropDown.isDisplayed()) {
				allDropdownList.selectByVisibleText(elementsInAllDropDownList.get(i).getText());
			}

		}

		for (WebElement valuesFromDropDown : elementsInAllDropDownList) {
			departmentsFromDropdown.add(valuesFromDropDown.getText());

		}

//		for (String stringOfdropDownValue : departmentsFromDropdown) {
//			System.out.println(stringOfdropDownValue);
//
//		}

		return departmentsFromDropdown;
	//	System.out.println(departmentsFromDropdown.size());;
	}
}
