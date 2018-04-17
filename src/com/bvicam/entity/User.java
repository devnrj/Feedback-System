package com.bvicam.entity;

public class User {
	private int id;
	private String name;
	private int yoj;
	private int yol;
	private String status;
	private String phoneno;
	private String email;
	private String pass;
	
	public User() {
	}
	public int getId() {
		return id;
	}
	
	public User(int id, String name, String pass,int yoj, int yol, String status, String phoneno, String email) {
		super();
		this.pass=pass;
		this.id = id;
		this.name = name;
		this.yoj = yoj;
		this.yol = yol;
		this.status = status;
		this.phoneno = phoneno;
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return pass;
	}
	public void setPassword(String pwd) {
		this.pass=pwd;
	}
	public int getYearOfJoining() {
		return yoj;   
	}
	public void setYearOfJoining(int year) {
		this.yoj = year;
	}
	public int getYearOfLeaving() {
		return yol;   
	}
	public void setYearOfLeaving(int year) {
		this.yol = year;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
}
