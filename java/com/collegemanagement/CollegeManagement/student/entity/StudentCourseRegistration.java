package com.collegemanagement.CollegeManagement.student.entity;

public class StudentCourseRegistration {
	
	private int studentCourseRegistrationId;
	private int studentId;
	private String studentName;
	private String courseCode;
	private String courseName;
	private int admissionYear;
	private String admissionDate;
	
	public StudentCourseRegistration() {
		
	}

	public int getStudentCourseRegistrationId() {
		return studentCourseRegistrationId;
	}

	public void setStudentCourseRegistrationId(int studentCourseRegistrationId) {
		this.studentCourseRegistrationId = studentCourseRegistrationId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getAdmissionYear() {
		return admissionYear;
	}

	public void setAdmissionYear(int admissionYear) {
		this.admissionYear = admissionYear;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	@Override
	public String toString() {
		return "StudentCourseRegistration [studentCourseRegistrationId=" + studentCourseRegistrationId + ", studentId="
				+ studentId + ", studentName=" + studentName + ", courseCode=" + courseCode + ", courseName="
				+ courseName + ", admissionYear=" + admissionYear + ", admissionDate=" + admissionDate + "]";
	}

}
