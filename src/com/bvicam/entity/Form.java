package com.bvicam.entity;

import java.util.ArrayList;

public class Form implements Comparable<Form>{ 
	private final int fid;
	private int teacherid;
	private int subid;
	private String status;
	private String fName;
	private ArrayList<Question> qList;
	private int fTrackerId;
	
	public Form(final int fid)
	{
		this.fid=fid;
	}
	public Form(int fid, int teacherid, int subid, String status, String fName,int fTrackerId) {
		super();
		this.fid = fid;
		this.teacherid = teacherid;
		this.subid = subid;
		this.status = status;
		this.fName = fName;
		this.fTrackerId = fTrackerId;
	}
	public Form(int fid, int teacherid, int subid, String status, String fName, ArrayList<Question> qList,
			int fTrackerId) {
		super();
		this.fid = fid;
		this.teacherid = teacherid;
		this.subid = subid;
		this.status = status;
		this.fName = fName;
		this.qList = qList;
		this.fTrackerId = fTrackerId;
	}

	public int getFormTrackerId() {
		return fTrackerId;
	}
	public void setFormTrackerId(int fTrackerId) {
		this.fTrackerId = fTrackerId;
	}
	public void setQuestions(QuesUsage qu) {
		 qList=QuesOps.getInstance().getQuestions(qu);
	}
	public void setQuestions(ArrayList<Question> ql) {
		qList=ql;
	}
	public ArrayList<Question> getQuestions(){
		return qList;
	}
	public void setFormName(String n) {
		fName=n;
	}
	public String getFormName() {
		return fName;
	}

	public String getFormStatus() {
		return status;
	}

	public void setFormStatus(String status) {
		this.status = status;
	}

	public int getFormTeacherId() {
		return teacherid;
	}
	
	public void setFormTeacherId(int teacherid) {
		this.teacherid = teacherid;
	}
	
	public int getFormSubId() {
		return subid;
	}
	
	public void setFormSubId(int subid) {
		this.subid = subid;
	}
	
	public int getFormId() {
		return this.fid;
	}
	@Override
	public int compareTo(Form second) {
		return this.fid-second.fid;
	}

}
