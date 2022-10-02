package com.collegemanagement.CollegeManagement.student.entity;

public class Student<studentId> {
	
	private int studentId;;
	private String studentName;
	private String studentAddress;
	private String studentcontact;
	private String studentEmailId;
	private String studentAddhar;

	public Student() {
		
	}

	public Student(int studentId, String studentName, String studentAddress, String studentcontact,
			String studentEmailId, String studentAddhar) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentcontact = studentcontact;
		this.studentEmailId = studentEmailId;
		this.studentAddhar = studentAddhar;
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

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentcontact() {
		return studentcontact;
	}

	public void setStudentcontact(String studentcontact) {
		this.studentcontact = studentcontact;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public String getStudentAddhar() {
		return studentAddhar;
	}

	public void setStudentAddhar(String studentAddhar) {
		this.studentAddhar = studentAddhar;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", studentcontact=" + studentcontact + ", studentEmailId=" + studentEmailId + ", studentAddhar="
				+ studentAddhar + "]";
	}
	
}
