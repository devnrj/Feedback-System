package com.bvicam.entity;

//import java.util.HashMap;
//Java program to illustrate 
//Java.util.HashMap
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class FeedbackRecord {
	ArrayList<String> answer = new ArrayList<>();

	int fr_id;
	int rollno;
	int subject_id;
	int form_id;
	public int getFr_id() {
		return fr_id;
	}
	public void setFr_id(int fr_id) {
		this.fr_id = fr_id;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getForm_id() {
		return form_id;
	}
	public void setForm_id(int form_id) {
		this.form_id = form_id;
		//ans.add("varun");
	}

	
	public static FeedbackRecord getFr() {
		return fr;
	}
	public static void setFr(FeedbackRecord fr) {
		FeedbackRecord.fr = fr;
	}
	public void setAnswer(String ans)
	{
		answer.add(ans);
		System.out.println(answer);
		
	}
	@Override
	public String toString() {
		return "FeedbackRecord [fr_id=" + fr_id + ", rollno=" + rollno + ", subject_id=" + subject_id + ", form_id="
				+ form_id + "]";
	}
	
	private static FeedbackRecord fr =null;

	public static FeedbackRecord getInstance(){
		synchronized(FeedbackRecord.class){
			if(fr==null){
				fr= new FeedbackRecord();
			}
		}
		return fr;
	}





}
