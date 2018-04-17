package com.bvicam.entity;

public class Student extends User{
	private String section;
	private String sem;
	
	public Student() {
	}
	
	public Student(String sem,String sec,String name,String pass,int yol,int yoj, String status,String email,String phone,int id) {
		super(id,name,pass,yoj,yol,status,phone,email);	
		this.sem=sem;
		this.section=sec;
	}
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
}
