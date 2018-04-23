package com.bvicam.entity;

import java.sql.Date;

public class FeedbackTracker {
	private int fTrackerid;
	private String batch_year;
	private int semester;
	private Date start_date;
	private Date end_date;
	private Date critical_date;
	private int section;
	
	public FeedbackTracker(int fTrackerid, String batch_year, int semester, Date start_date, Date end_date,
			Date critical_date, int section) {
		super();
		this.fTrackerid = fTrackerid;
		this.batch_year = batch_year;
		this.semester = semester;
		this.start_date = start_date;
		this.end_date = end_date;
		this.critical_date = critical_date;
		this.section = section;
	}
	public int getfTrackerid() {
		return fTrackerid;
	}
	public void setfTrackerid(int fTrackerid) {
		this.fTrackerid = fTrackerid;
	}
	public String getBatchYear() {
		return batch_year;
	}
	public void setBatchYear(String batch_year) {
		this.batch_year = batch_year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public Date getStartDate() {
		return start_date;
	}
	public void setStartDate(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEndDate() {
		return end_date;
	}
	public void setEndDate(Date end_date) {
		this.end_date = end_date;
	}
	public Date getCriticalDate() {
		return critical_date;
	}
	public void setCriticalDate(Date critical_date) {
		this.critical_date = critical_date;
	}
}
