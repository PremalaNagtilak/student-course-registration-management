package com.collegemanagement.CollegeManagement.student.studentImpl;

import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.collegemanagement.CollegeManagement.entity.Branch;
import com.collegemanagement.CollegeManagement.service.CourseService;
import com.collegemanagement.CollegeManagement.student.entity.Student;
import com.collegemanagement.CollegeManagement.student.entity.StudentCourseRegistration;
import com.collegemanagement.CollegeManagement.student.studentinterface.IStudentCourseRegistration;

public class StudentCourseRegistrationImpl implements IStudentCourseRegistration {

	@SuppressWarnings("rawtypes")
	@Override
	public StudentCourseRegistration register(Map<Integer, Student> studentMap, Map<String, Branch> branches,
			Map<Integer, StudentCourseRegistration> registrationMap, int studentCourseRegistrationId) {
		if (studentMap.isEmpty()) {
			System.out.println(
					"You don't have any student to register. Please first add student then you can register the student..!!");
			return null;
		}

		if (branches.isEmpty()) {
			System.out.println(
					"You don't have any branch to register. Please first add branch then you can register the student..!!");
			return null;
		}

		Scanner input = new Scanner(System.in);
		StudentCourseRegistration studentCourseRegistration = new StudentCourseRegistration();
		studentCourseRegistration.setStudentCourseRegistrationId(studentCourseRegistrationId);

		System.out.println("Enter Student Id : ");
		int studentId = input.nextInt();
		studentCourseRegistration.setStudentId(studentId);

		StudentDetailImpl studentDetail = new StudentDetailImpl();
		Student student = studentDetail.findStudentById(studentMap, studentId);
		if (null == student) {
			System.out.println("Student does not exist with student Id : " + studentId
					+ " So, please enter correct student id and try again..!!");
			register(studentMap, branches, registrationMap, studentCourseRegistrationId);
		}
		studentCourseRegistration.setStudentName(student.getStudentName());

		input.nextLine();
		System.out.println("Enter Course Code : ");
		String courseCode = input.nextLine();
		CourseService courseService = new CourseService();
		Branch course = courseService.searchCourseByCourseCode(branches, courseCode);
		if (null == course) {
			System.out.println("Course does not exist with course code : " + courseCode
					+ " So, please enter correct course code and try again..!!");
			register(studentMap, branches, registrationMap, studentCourseRegistrationId);
		}
		studentCourseRegistration.setCourseCode(courseCode);
		studentCourseRegistration.setCourseName(course.getBranchName());

		System.out.println("Enter Admission Year (e.g. 1, 2, 3, 4, etc) : ");
		studentCourseRegistration.setAdmissionYear(input.nextInt());
		input.nextLine();
		System.out.println("Enter Admission Date in DD-MM-YYYY format : ");
		studentCourseRegistration.setAdmissionDate(input.nextLine());

		registrationMap.put(studentCourseRegistrationId, studentCourseRegistration);

		System.out.println("Student has been registered successfully..!!");
		return studentCourseRegistration;
	}

	@Override
	public StudentCourseRegistration update(Map<String, Branch> branches,
			Map<Integer, StudentCourseRegistration> registrationMap) {
		if (branches.isEmpty()) {
			System.out.println(
					"You don't have any branch to register. Please first add branch then you can register the student..!!");
			return null;
		}

		Scanner input = new Scanner(System.in);
		System.out.println("Enter student id : ");
		int studentId = input.nextInt();

		StudentCourseRegistration student = findStudentCourseRegistrationByStudentId(registrationMap, studentId);
		if (null != student) {

			System.out.println("Do you want to update course code? Please enter y/n");
			char isCourseCode = input.next().charAt(0);
			if (isCourseCode == 'y') {
				input.nextLine();
				System.out.println("Enter Course Code : ");
				String courseCode = input.nextLine();
				CourseService courseService = new CourseService();
				Branch course = courseService.searchCourseByCourseCode(branches, courseCode);
				if (null == course) {
					System.out.println("Course does not exist with course code : " + courseCode
							+ " So, please enter correct course code and try again..!!");
					update(branches, registrationMap);
				}
				student.setCourseCode(courseCode);
				student.setCourseName(course.getBranchName());
			}

			System.out.println("Do you want to update year of admission? Please enter y/n");
			char isYear = input.next().charAt(0);
			if (isYear == 'y') {
				System.out.println("Enter updated year of admission (e.g. 1, 2, 3, 4, etc) :");
				int year = input.nextInt();
				student.setAdmissionYear(year);
			}
			System.out.println("Do you want to update date of admission? Please enter y/n");
			char isDate = input.next().charAt(0);
			if (isDate == 'y') {
				System.out.println("Enter updated date of admission in DD-MM-YYYY format :");
				String date = input.next();
				student.setAdmissionDate(date);
			}
			System.out.println("Updated student course registration details successfully..!!");
			registrationMap.put(student.getStudentCourseRegistrationId(), student);
			//System.out.println(student);
			return student;
		} else {
			System.out.println("Student is not yet registered, Please enter correct student id..!!");
			return null;
		}

	}

	@Override
	public StudentCourseRegistration findStudentCourseRegistrationByStudentId(
			Map<Integer, StudentCourseRegistration> registrationMap, int studentId) {
		if (registrationMap.isEmpty())
			return null;

		StudentCourseRegistration student = new StudentCourseRegistration();
		for (Entry<Integer, StudentCourseRegistration> entry : registrationMap.entrySet()) {
			student = (StudentCourseRegistration) entry.getValue();
			if (studentId == student.getStudentId()) {
				break;
			} else {
				student = null;
			}
		}
		return student;
	}

	@Override
	public void showRegisteredStudents(Map<Integer, StudentCourseRegistration> registrationMap) {
		if (registrationMap.isEmpty()) {
			System.out.println("Student list is empty..!!");
		}
		for (Entry<Integer, StudentCourseRegistration> entry : registrationMap.entrySet()) {
			System.out.print("student Id:" + entry.getValue().getStudentId() + "\t Student Name:"
					+ entry.getValue().getStudentName() + "\t Course Code:" + entry.getValue().getCourseCode()
					+ "\t Course Name:" + entry.getValue().getCourseName() + "\t Admission Year:"
					+ entry.getValue().getAdmissionYear() + "\t Admission Date:" + entry.getValue().getAdmissionDate()
					+ "\n");
		}
	}

	@Override
	public void delete(Map<Integer, StudentCourseRegistration> registrationMap) {
		if (registrationMap.isEmpty()) {
			System.out.println("Students are not yet registered..!!");
		}
		System.out.println();
		Scanner input=new Scanner(System.in);
		System.out.println("Enter student id which you want to cancel registration : ");
		int studentId = input.nextInt();
		boolean result = registrationMap.entrySet().removeIf(entry -> entry.getValue().getStudentId()==studentId);
		
		if(result) System.out.println("Student deleted successfully..!!"); 
		else System.out.println("Unable to find student with this student id, please enter correct student id..!!");;
		
	}

}
