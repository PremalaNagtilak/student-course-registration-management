package com.collegemanagement.CollegeManagement.student.studentinterface;

import java.util.Map;

import com.collegemanagement.CollegeManagement.entity.Branch;
import com.collegemanagement.CollegeManagement.student.entity.Student;
import com.collegemanagement.CollegeManagement.student.entity.StudentCourseRegistration;

public interface IStudentCourseRegistration {

	@SuppressWarnings("rawtypes")
	public StudentCourseRegistration register(Map<Integer, Student> studentMap, Map<String, Branch> branches,
			Map<Integer, StudentCourseRegistration> registrationMap, int studentCourseRegistrationId);

	public StudentCourseRegistration update(Map<String, Branch> branches,
			Map<Integer, StudentCourseRegistration> registrationMap);

	public StudentCourseRegistration findStudentCourseRegistrationByStudentId(
			Map<Integer, StudentCourseRegistration> registrationMap, int studentId);

	public void showRegisteredStudents(Map<Integer, StudentCourseRegistration> registrationMap);

	void delete(Map<Integer, StudentCourseRegistration> registrationMap);

}
