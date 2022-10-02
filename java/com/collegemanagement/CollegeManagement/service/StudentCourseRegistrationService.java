package com.collegemanagement.CollegeManagement.service;

import java.util.Map;
import java.util.Scanner;

import com.collegemanagement.CollegeManagement.constant.CollegeConstants;
import com.collegemanagement.CollegeManagement.entity.Branch;
import com.collegemanagement.CollegeManagement.student.entity.Student;
import com.collegemanagement.CollegeManagement.student.entity.StudentCourseRegistration;
import com.collegemanagement.CollegeManagement.student.studentImpl.StudentCourseRegistrationImpl;
import com.collegemanagement.CollegeManagement.student.studentinterface.IStudentCourseRegistration;

public class StudentCourseRegistrationService {

	IStudentCourseRegistration studentCourseRegistrationImpl = new StudentCourseRegistrationImpl();

	public StudentCourseRegistrationService() {

	}

	public void studentCourseRegistrationManagement(Map<Integer, Student> studentMap, Map<String, Branch> branches,
			Map<Integer, StudentCourseRegistration> studentCourseRegistrationMap, Scanner input) {
		int studentOption;
		int studentCourseRegistrationId = 1;
		char studentOptionExit;
		do {
			System.out.println(CollegeConstants.SELECT_OPTION);
			System.out.println(CollegeConstants.STUDENT_COURSE_REGISTRATION_MENU);
			studentOption = input.nextInt();
			switch (studentOption) {
			case 1:
				studentCourseRegistrationImpl.register(studentMap, branches, studentCourseRegistrationMap,
						studentCourseRegistrationId);
				studentCourseRegistrationId++;
				break;
			case 2:
				studentCourseRegistrationImpl.update(branches, studentCourseRegistrationMap);
				break;
			case 3:  studentCourseRegistrationImpl.delete(studentCourseRegistrationMap);
				break;
			case 4:
				studentCourseRegistrationImpl.showRegisteredStudents(studentCourseRegistrationMap);
				break;
			}

			System.out.println("With the student course registration module, " + CollegeConstants.CONTINUE_Y_N);
			studentOptionExit = input.next().charAt(0);
		} while ((studentOptionExit == 'Y' || studentOptionExit == 'y') && studentOption != 5);
	}

}
