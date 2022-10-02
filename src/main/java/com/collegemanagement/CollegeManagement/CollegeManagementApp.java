package com.collegemanagement.CollegeManagement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.collegemanagement.CollegeManagement.constant.CollegeConstants;
import com.collegemanagement.CollegeManagement.entity.Branch;
import com.collegemanagement.CollegeManagement.entity.College;
import com.collegemanagement.CollegeManagement.service.CourseService;
import com.collegemanagement.CollegeManagement.service.StudentCourseRegistrationService;
import com.collegemanagement.CollegeManagement.service.StudentService;
import com.collegemanagement.CollegeManagement.student.entity.Student;
import com.collegemanagement.CollegeManagement.student.entity.StudentCourseRegistration;
import com.collegemanagement.CollegeManagement.student.studentImpl.StudentDetailImpl;
import com.collegemanagement.CollegeManagement.student.studentinterface.IStudentDetail;
import com.collegemanagement.CollegeManagement.utility.CollegeUtility;

/**
 * Author: Premala Nagtilak!
 *
 */

public class CollegeManagementApp {

	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
		CollegeUtility.loadProperties(properties);
		Scanner input = new Scanner(System.in);
		StudentService studentService = new StudentService();
		CourseService courseService = new CourseService();
		IStudentDetail studentDetail = new StudentDetailImpl();
		StudentCourseRegistrationService studentCourseRegistrationService = new StudentCourseRegistrationService();
		
		Map<Integer, Student> studentMap=new HashMap<Integer, Student>();
		Map<String, Branch> branches = new HashMap<String, Branch>();
		Map<Integer, StudentCourseRegistration> studentCourseRegistrationMap = new HashMap<Integer, StudentCourseRegistration>();
		
		branches = Branch.getBranches(properties);
		
		CollegeUtility.showCollegeDetails();
		System.out.println(CollegeConstants.SELECT_OPTION);
		System.out.println(CollegeConstants.MAIN_MENU);
		int option = input.nextInt();
		do {
			switch(option) {
			
			case 1: studentService.studentManagement(studentDetail, studentMap, input);
				break;
				
			case 2: courseService.courseManagement(properties, branches, input);
				break;
				
			case 3: studentCourseRegistrationService.studentCourseRegistrationManagement(studentMap, branches, studentCourseRegistrationMap, input);
				break;
				
			}
			System.out.println();
			System.out.println(CollegeConstants.SELECT_OPTION);
			System.out.println(CollegeConstants.MAIN_MENU);
			option = input.nextInt();
		}while(option!=4);
		System.out.println();
		System.out.println(CollegeConstants.THANKFUL + College.getCollege().getCollegeName() +".......!!");
		System.exit(0);
		
	}
	
}
