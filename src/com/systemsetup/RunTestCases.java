package com.systemsetup;

import java.io.IOException;

public class RunTestCases {

	static UserGetsElementFromAllList obj;
	static AllDropDownInputFromlFile obj1;

	public static void validateDropDownList() {

	}

	public static void main(String[] args) throws IOException {

		obj = new UserGetsElementFromAllList();
		obj1 = new AllDropDownInputFromlFile();

		obj.getSetup();
		obj.workingURL();
		System.out.println("********************************");
		System.out.println("List from Amazon");
		System.out.println("********************************");
		obj.getDropDownList();
		System.out.println("********************************");
		System.out.println("List from File");
		System.out.println("********************************");
		obj1.dropdownListFromFile();

		if (obj.getDropDownList().equals(obj1.dropdownListFromFile())) {
			System.out.println("********************************");
			System.out.println("Drop-down list from file matches with drop-down list from Amazon website.");
		} else {
			System.out.println("********************************");
			System.out.println("Drop-downs DO NOT match");
		}
	}
}