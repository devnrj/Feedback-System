package com.bvicam.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class FormTemplate {
	private QuesUsage qu;
	private ArrayList<Question> qlist;
	
	public FormTemplate(QuesUsage qu, ArrayList<Question> qlist, String fName) {
		this.qu = qu;
		this.qlist = qlist;
	}

	public QuesUsage getQu() {
		return qu;
	}

	public void setQu(QuesUsage qu) {
		this.qu = qu;
	}

	public ArrayList<Question> getQlist() {
		return qlist;
	}

	public void setQlist(ArrayList<Question> qlist) {
		this.qlist = qlist;
	}
	
	
}
