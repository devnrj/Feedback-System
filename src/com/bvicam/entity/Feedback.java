package com.bvicam.entity;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Feedback {
	private final int fid;
	private int rollno;
	private Timestamp fupdtime;
	private String status;
	private int score;
	private int form_id;
	private ArrayList<Answer> answer;
	public Feedback(final int id) {
		fid=id;
	}
	
	public Feedback(int fid, int rollno, String status, int score, int form_id, ArrayList<Answer> answer,Timestamp time) {
		super();
		this.fid = fid;
		this.rollno = rollno;
		this.status = status;
		this.score = score;
		this.form_id = form_id;
		this.answer = answer;
		this.fupdtime = time;
	}

	public int getRollno() {
		return rollno;
	}
	public Timestamp getTime() {
		return fupdtime;
	}
	public void setTime(Timestamp ts) {
		fupdtime=ts;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getFormid() {
		return form_id;
	}
	public void setFormid(int form_id) {
		this.form_id = form_id;
	}
	public ArrayList<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(ArrayList<Answer> answer) {
		this.answer = answer;
	}
	public int getFid() {
		return fid;
	}
	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", rollno=" + rollno + ", status=" + status + ", score=" + score + ", form_id="
				+ form_id + ", answer=" + answer + "]";
	}
	
}
