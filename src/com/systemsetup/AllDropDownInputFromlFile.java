package com.systemsetup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AllDropDownInputFromlFile {

	public String inputFile;

	List<String> departmentsFromFile;
	
	//public void dropdownListFromFile() throws IOException {
	public List<String> dropdownListFromFile() throws IOException {

		String projectPath = System.getProperty("user.dir");

		String filePath = projectPath + ("//Files//all_department.txt");

		File file = new File(filePath);

		BufferedReader br = new BufferedReader(new FileReader(file));

		departmentsFromFile = new ArrayList<String>();

		String st;
		while ((st = br.readLine()) != null)
			departmentsFromFile.add(st);

/*		for (String list : departmentsFromFile) {
			System.out.println(list);
		}*/
		return departmentsFromFile;
		//System.out.println(departmentsFromFile.size());
	}

}
