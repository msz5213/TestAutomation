package com.systemsetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UserIsAbleToValidateSearchInputField extends BaseTest {

	WebElement searchBox;

/*	public UserIsAbleToValidateSearchInputField(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}*/

	@Test
	public void userIsAbleToVerifySearchInputField() {
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		if (searchBox.isEnabled() && searchBox.isEnabled()) {
			searchBox.sendKeys("brakes");
			searchBox.submit();
			System.out.println("User is able to click on search box, type and search for items");
		}
	}
}
