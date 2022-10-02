package com.collegemanagement.CollegeManagement.service;

import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.collegemanagement.CollegeManagement.entity.Branch;

public class CourseService {

	public CourseService() {
		
	}

	public void courseManagement(Properties properties, Map<String, Branch> branches, Scanner input) {
		branches = Branch.getBranches(properties);
		System.out.println("Branch Code\t\tBranch Name\t\t\t\tNo Of Seats Available");
		for (Map.Entry<String, Branch> entry : branches.entrySet()) {
			String key = entry.getKey();
			Branch branch = entry.getValue();
			System.out.println(branch.getBranchCode()+"\t\t"+branch.getBranchName()+"\t\t\t\t"+branch.getNoOfSeatsAvailable());
		}
//		int courseOption;
//		char courseOptionExit;
//		do {
//			System.out.println(CollegeConstants.SELECT_OPTION);
//			System.out.println(CollegeConstants.STUDENT_MENU);
//			courseOption = input.nextInt();
//			switch(courseOption) {
//			case 1: courseDetail.add(branches);
//				break;
//			case 2: courseDetail.update(branches);
//				break;
//			case 3: courseDetail.delete(branches);
//				break;
//			case 4: courseDetail.searchCourseByCourseCode(branches);
//				break;
//			case 4: courseDetail.getAllCourse(branches);
//				break;
//			}
//			
//			System.out.println("With the student module, "+CollegeConstants.CONTINUE_Y_N);
//			courseOptionExit = input.next().charAt(0);
//		}while((courseOptionExit=='Y' || courseOptionExit=='y') && courseOption!=5);
	}
	
	public Branch searchCourseByCourseCode(Map<String, Branch> branches, String courseCode) {
		if(branches.isEmpty()) {
			System.out.println("No course available yet..!!");
			return null;
		}
		Branch branch = null;
		for (Map.Entry<String, Branch> entry : branches.entrySet()) {
			String key = entry.getKey();
			if(key.equalsIgnoreCase(courseCode)) {
				branch = (Branch)entry.getValue();
				break;
			}
		}
		return branch;
	}
	
}
