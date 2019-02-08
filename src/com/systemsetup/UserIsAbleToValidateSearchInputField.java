package com.systemsetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UserIsAbleToValidateSearchInputField extends BaseTest {

	@Test(enabled = true, priority = 100)
	public void userIsAbleToVerifySearchInputField() throws InterruptedException {

		WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));

		if (searchBox.isEnabled() && searchBox.isEnabled()) {
			searchBox.sendKeys("brakes");
			searchBox.submit();
			System.out.println("User is able to click on search box, type and search for items");
		} else {
			System.out.println("Searchinng for items has failed.");
		}
	}

}
