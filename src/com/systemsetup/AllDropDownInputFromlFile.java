package com.systemsetup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AllDropDownInputFromlFile extends BaseTest {

	public String inputFile;

	List<String> departmentsFromFile;

	// public void dropdownListFromFile() throws IOException {
	public List<String> dropdownListFromFile() throws IOException {

		String projectPath = System.getProperty("user.dir");

		String filePath = projectPath + ("//Files//all_department.txt");

		File file = new File(filePath);

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));

		departmentsFromFile = new ArrayList<String>();

		String st;
		while ((st = br.readLine()) != null)
			departmentsFromFile.add(st);

		/*
		 * for (String list : departmentsFromFile) { System.out.println(list); }
		 */
		return departmentsFromFile;
		// System.out.println(departmentsFromFile.size());
	}

	@Test(enabled = true, priority = 200)
	public void compareData() throws IOException {

		UserGetsElementFromAllList obj = new UserGetsElementFromAllList();

		AllDropDownInputFromlFile obj1 = new AllDropDownInputFromlFile();

		System.out.println("********************************");
		System.out.println("List from Amazon");
		System.out.println("********************************");
		System.out.println(obj.getDropDownList());
		System.out.println("********************************");
		System.out.println("List from File");
		System.out.println("********************************");
		System.out.println(obj1.dropdownListFromFile());

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

	}

}
