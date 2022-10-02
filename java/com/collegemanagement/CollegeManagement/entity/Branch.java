package com.collegemanagement.CollegeManagement.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Branch {

	private String branchCode;
	private String branchName;
	private int noOfSeatsAvailable;
	
	public Branch() {
		
	}
	
	public Branch(String branchCode, String branchName, int noOfSeatsAvailable) {
		super();
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}
	
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branch_Code) {
		this.branchCode = branch_Code;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branch_Name) {
		this.branchName = branch_Name;
	}
	public int getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}
	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}
	@Override
	public String toString() {
		return "Branch [branchCode=" + branchCode + ", branchName=" + branchName + ", noOfSeatsAvailable="
				+ noOfSeatsAvailable + "]";
	}
	
	public static Map<String, Branch> getBranches(Properties properties) {
		Map<String,String> branchMap=new HashMap<String,String>();
		Map<String,Branch> branches=new HashMap<String,Branch>();
		
		String branchProperty = properties.getProperty("branches");
		String[] branchArray = branchProperty.split(",");
		
		Arrays.asList(branchArray).stream().map(b->b.split(":")).forEach(b->branchMap.put(b[0], b[1]));
		branchMap.entrySet().forEach(b->branches.put(b.getKey(), new Branch(b.getKey(), ((b.getValue().split("-"))[0]), Integer.parseInt((b.getValue().split("-"))[1])) ));
		
//		for (Map.Entry<String, String> entry : branchMap.entrySet()) {
//			String key = entry.getKey();
//			String val = entry.getValue();
//			String[] value = val.split("-");
//			branches.put(key, new Branch(key, value[0], Integer.parseInt(value[1])));
//		}
		
//		branchMap.put("CSE", new Branch("CSE", "Computer Science And Engineering", 20));
//		branchMap.put("ECE", new Branch("ECE", "Electronics And Telecomunication Enginnering", 30));
//		branchMap.put("ME", new Branch("ME", "Mechanical Engineering", 50));
		return branches;
	}
	
}
