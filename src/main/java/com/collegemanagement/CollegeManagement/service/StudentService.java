package com.collegemanagement.CollegeManagement.service;

import java.util.Map;
import java.util.Scanner;

import com.collegemanagement.CollegeManagement.constant.CollegeConstants;
import com.collegemanagement.CollegeManagement.student.entity.Student;
import com.collegemanagement.CollegeManagement.student.studentinterface.IStudentDetail;

public class StudentService {

	public StudentService() {
		
	}
	
	public void studentManagement(IStudentDetail studentDetail, Map<Integer,Student> studentMap, Scanner input) {
		int studentOption;
		int studentId = 1;
		char studentOptionExit;
		do {
			System.out.println();
			System.out.println(CollegeConstants.SELECT_OPTION);
			System.out.println(CollegeConstants.STUDENT_MENU);
			studentOption = input.nextInt();
			switch(studentOption) {
			case 1: studentDetail.add(studentMap, studentId);
				studentId++;
				break;
			case 2: studentDetail.update(studentMap);
				break;
			case 3: studentDetail.delete(studentMap);
				break;
			case 4: studentDetail.getAllStudent(studentMap);
				break;
			}
			
			System.out.println("With the student module, "+CollegeConstants.CONTINUE_Y_N);
			studentOptionExit = input.next().charAt(0);
		}while((studentOptionExit=='Y' || studentOptionExit=='y') && studentOption!=5);
	}
	
}
