package com.collegemanagement.CollegeManagement.student.studentImpl;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.collegemanagement.CollegeManagement.student.entity.Student;
import com.collegemanagement.CollegeManagement.student.studentinterface.IStudentDetail;

public class StudentDetailImpl implements IStudentDetail {
	Scanner sc = new Scanner(System.in);

	@Override
	public Map<Integer, Student> add(Map<Integer, Student> studentMap, int studentId) {
		// Map<Integer,Student> studentMap=new HashMap<Integer,Student>();
		// student = new Student(1, "Premala", "Pune", "8600483422", "ram@gmail.com",
		// "Adhar", "DOA", 1);

		Student student = new Student();
		student.setStudentId(studentId);
		setStudent(student);
		studentMap.put(student.getStudentId(), student);
		System.out.println("Student saved successfully..!!\n");
		return studentMap;
	}

	@Override
	public void delete(Map<Integer, Student> studentMap) {
		System.out.println();
		System.out.println("Enter student id which you want to delete : ");
		int studentId = sc.nextInt();
		
		boolean result = studentMap.entrySet().removeIf(entry -> entry.getKey()==studentId);
		
		if(result) System.out.println("Student deleted successfully..!!"); 
		else System.out.println("Unable to delete student, please enter correct student id..!!");;
	}

	@Override
	public void getAllStudent(Map<Integer, Student> studentMap) {
		if(studentMap.isEmpty()) {
			System.out.println("Student list is empty..!!");
		}
		for (Entry<Integer, Student> entry : studentMap.entrySet()) {
			System.out.print("student Id:" + entry.getValue().getStudentId() + "\t Student Name:"
					+ entry.getValue().getStudentName() + "\t Student Address:" + entry.getValue().getStudentAddress()
					+ "\t Student Contact no:" + entry.getValue().getStudentcontact() + "\t student Aadhar no:"
					+ entry.getValue().getStudentAddhar() + "\t Student Email:" + entry.getValue().getStudentEmailId() + "\n");
		}

	}

	@Override
	public Student setStudent(Student student) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter student details");
		System.out.println("Enter Name: ");
		student.setStudentName(input.nextLine());
		System.out.println("Enter Address: ");
		student.setStudentAddress(input.nextLine());
		System.out.println("Enter Contact no:");
		student.setStudentcontact(input.nextLine());
		System.out.println("Enter Email Id:");
		student.setStudentEmailId(input.nextLine());
		System.out.println("Enter  Aadhaar no:");
		student.setStudentAddhar(input.nextLine());
		return student;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void update(Map<Integer, Student> studentMap) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter student id : ");
		int studentId = input.nextInt();
		
		Student student = findStudentById(studentMap, studentId);
		if(null!=student) {

			System.out.println("Do you want to update student name? Please enter y/n");
			char isName = input.next().charAt(0);
			if(isName=='y') {
				input.nextLine();
				System.out.println("Enter updated student name:");
				String name = input.nextLine();
				student.setStudentName(name);
			} 

			System.out.println("Do you want to update student address? Please enter y/n");
			char isAddress = input.next().charAt(0);
			if(isAddress=='y') {
				input.nextLine();
				System.out.println("Enter updated student address:");
				String address = input.nextLine();
				student.setStudentAddress(address);
			}

			System.out.println("Do you want to update student contact? Please enter y/n");
			char isContact = input.next().charAt(0);
			if(isContact=='y') {
				System.out.println("Enter updated contact number:");
				String contact = input.next();
				student.setStudentcontact(contact);
			}
			System.out.println("Do you want to update student Email? Please enter y/n");
			char isEmail = input.next().charAt(0);
			if(isEmail=='y') {
				System.out.println("Enter updated email:");
				String email = input.next();
				student.setStudentEmailId(email);
			}
			System.out.println("Updated student details successfully..!!");
			System.out.println(student);
		} else {
			System.out.println("Student does not exist, Please enter correct student id..!!");
		}
		
	}

	@Override
	public Student findStudentById(Map<Integer, Student> studentMap, int studentId) {
		if(studentMap.isEmpty()) return null;
		
		Student student = new Student();
		for (Entry<Integer, Student> entry : studentMap.entrySet()) {
			if (studentId == entry.getKey()) {
				student = (Student)entry.getValue();
				break;
			}
		}
		return student;
	}

}
