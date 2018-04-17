package com.bvicam.entity;

public enum QuesType{
	MCQ("mcq",0) ,TEXT("text",1);
	private String name;
	private int id;
	QuesType(String name,int id){
		this.name=name;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
}
