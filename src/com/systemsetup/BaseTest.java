package com.systemsetup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class BaseTest {
	
	WebElement element;
	WebDriver driver;

	String expectedURL = "https://www.amazon.com/";

	/*public BaseTest(WebDriver driver) {
		this.driver = driver;
	}*/

	// What is the default timeout in selenium - 30 sec

	// Selenium will wait 60 sec to find the element. It will then move onto the
	// next step.

	// If we use assert and the test case fails, the rest of the test cases will not
	// run
	// If we use verify (if), even if the test case fails, the rest if the test
	// cases will run
	// JUnit is a framework of java
	// What the difference between JUnit and TestNG
	// - JUnit has no reporting, TestNG has reporting
	// What is the synchronization
	// Implicit wait, explicit wait, thread.sleep, fluent wait
    
	@BeforeClass
	public void getSetup() {
		/** Making OS dynamic between Mac and Windows */
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println(
				"*****************************************************************************************************");
		System.out.println(os);

		/** Windows driver path */
		String winPath = System.getProperty("user.dir");
		String winDriverPath = winPath + "\\DriverWin\\chromedriver.exe";

		/** Mac driver path */
		String macPath = System.getProperty("user.home");
		String macDriverPath = macPath + "/chromedriver/chromedriver";

		/** Tell Eclipse which driver to use depending on OS */
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", macDriverPath);
			System.out.println(
					"*****************************************************************************************************");
			System.out.println(macPath);
			System.out.println(
					"*****************************************************************************************************");
		} else {
			System.setProperty("webdriver.chrome.driver", winDriverPath);
			System.out.println(
					"*****************************************************************************************************");
			System.out.println(winDriverPath);
			System.out.println(
					"*****************************************************************************************************");
		}
		driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void workingURL() {
		driver.navigate().to(expectedURL);
		String actualSite = driver.getCurrentUrl();

		try {
			Assert.assertEquals(expectedURL, actualSite);
			System.out.println("Actual url matches expected url");
		} catch (Exception e) {
			System.out.println("Actual url do not match expected url");
		}
	}

	@AfterMethod
	public void segregateTestCases() {
		System.out.println("Test case has run");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}

