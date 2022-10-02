package com.collegemanagement.CollegeManagement.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.collegemanagement.CollegeManagement.entity.College;

public class CollegeUtility {

	public static Properties loadProperties(Properties properties) throws IOException {
		try {
			properties.load(new FileReader("src//main//resources//application.properties"));
		} catch (Exception e) {
			System.out.println("Error while reading preoperty file... ==> "+e.getMessage());
		}
		return properties;
	}
	
	public static void showCollegeDetails() {
		System.out.println("\n\t\t!!!...Welcome To College Management System...!!!\n");
		System.out.println("\t\t" + College.getCollege().getCollegeName());
		System.out.println("\t\t" + College.getCollege().getAddress());
		System.out.println();
	}
}
