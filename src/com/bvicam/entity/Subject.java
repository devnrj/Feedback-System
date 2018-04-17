package com.bvicam.entity;

public class Subject {
	private final int id;
	private String name;
	private int code;
	private String status;
	private String type;
	
	public Subject(final int id) {
		this.id=id;
	}

	public Subject(final int id, String name, int code, String status, String type) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.status = status;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}
	
	
}
