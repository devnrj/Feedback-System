package com.bvicam.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Feedback {
	int fid;
	int rollno;
	int subject_id;
	int form_id;
	ArrayList<String> answer = new ArrayList<>();
	public int getFid() {
		return fid;
	}
	public void setFid(int fr_id) {
		this.fid = fr_id;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getSubjectId() {
		return subject_id;
	}
	public void setSubjectId(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getFormId() {
		return form_id;
	}
	public void setFormId(int form_id) {
		this.form_id = form_id;
	}
	public void setAnswer(String ans){
		answer.add(ans);
		System.out.println(answer);
	}
	@Override
	public String toString() {
		return "FeedbackRecord [fr_id=" + fid + ", rollno=" + rollno + ", subject_id=" + subject_id + ", form_id="
				+ form_id + "]";
	}
}
