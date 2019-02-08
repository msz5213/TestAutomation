package com.systemsetup;

import java.io.IOException;

import org.testng.Assert;

public class RunTestCases {

	static UserGetsElementFromAllList obj;
	static AllDropDownInputFromlFile obj1;
	//static UserIsAbleToValidateSearchInputField obj3;

	public static void validateDropDownList() {

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		obj = new UserGetsElementFromAllList();
		obj1 = new AllDropDownInputFromlFile();
		//obj3 = new UserIsAbleToValidateSearchInputField();

		obj.getSetup();
		obj.workingURL();
		System.out.println("********************************");
		//obj3.userIsAbleToVerifySearchInputField();
		System.out.println("********************************");
		System.out.println("List from Amazon");
		System.out.println("********************************");
		System.out.println(obj.getDropDownList());
		// obj.getDropDownList();
		System.out.println("********************************");
		System.out.println("List from File");
		System.out.println("********************************");
		System.out.println(obj1.dropdownListFromFile());
		obj.segregateTestCases();
		// obj1.dropdownListFromFile();

		if (obj.getDropDownList().equals(obj1.dropdownListFromFile())) {
			System.out.println("********************************");
			System.out.println("Drop-down list from file matches with drop-down list from Amazon website.");
		} else {
			System.out.println("********************************");
			System.out.println("Drop-downs DO NOT match");
		}

		try {
			Assert.assertEquals(obj.getDropDownList(), obj1.dropdownListFromFile());
		} catch (Exception e) {
			System.out.println(e);
		}
		obj.segregateTestCases();
		obj.closeBrowser();
	}
}
