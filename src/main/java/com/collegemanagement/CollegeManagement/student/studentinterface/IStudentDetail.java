package com.collegemanagement.CollegeManagement.student.studentinterface;

import java.util.Map;

import com.collegemanagement.CollegeManagement.student.entity.Student;

public interface IStudentDetail {

	public Map<Integer,Student> add(Map<Integer,Student> studentMap, int studentId);
	
	public Student setStudent(Student student);

	void getAllStudent(Map<Integer, Student> studentMap);

	void update(Map<Integer, Student> studentMap);

	public Student findStudentById(Map<Integer, Student> studentMap, int studentId);

	void delete(Map<Integer, Student> studentMap);

	
}
