package com.bvicam.entity;

public class Answer {
	private final int aid;
	private int fid;
	private int qid;
	private char mcq;
	private String text;
	
	public Answer(final int aid) {
		this.aid=aid;
	}
	public Answer(final int aid,int fid) {
		this.aid=aid;
		this.fid=fid;
	}
	public Answer(final int aid, int fid, int qid, char mcq, String text) {
		super();
		this.aid = aid;
		this.fid = fid;
		this.qid = qid;
		this.mcq = mcq;
		this.text = text;
	}
	public int getAid() {
		return aid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public char getMcq() {
		return mcq;
	}
	public void setMcq(char mcq) {
		this.mcq = mcq;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
