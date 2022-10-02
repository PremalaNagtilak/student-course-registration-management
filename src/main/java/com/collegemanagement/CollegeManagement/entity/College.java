package com.collegemanagement.CollegeManagement.entity;

import java.util.Map;

public class College {

	private int collegeId;
	private String collegeName;
	private String address;
	
	public College() {
	}
	
	public College(int collegeId, String collegeName, String address) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.address = address;
	}

	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", address=" + address + "]";
	}
	
	public static College getCollege(){
		College college = new College(101, "Sinhgad College Of Engineering", "Korti, Tal-Pandharpur, Dist-Solapur, 413304");
		return college;
	}
}
