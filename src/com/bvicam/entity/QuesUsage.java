package com.bvicam.entity;

public enum QuesUsage {
	GENERAL("general",0),LIBRARY("library",1),ADMINISTRATOR("administrator",2),LABORATORY("laboratory",3),
	INSTITUTE("institute",4),MISC("misc",5);
	
	private String name;
	private int id;
	
	QuesUsage(String name,int id) {
		this.name=name;
		this.id=id;
	}
	public String getName() {
		return this.name;
	}
	public int getId() {
		return this.id;
	}
	
}
