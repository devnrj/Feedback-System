package com.bvicam.entity;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bvicam.dal.AnswerDao;

public class AnswerOps {
	private static AnswerOps ao = null;
	public static AnswerOps getInstance() {
		synchronized(AnswerOps.class) {
			if(ao==null) {
				ao = new AnswerOps();
			}
		}
		return ao;
	}
	public int create(ArrayList<Answer> answers) throws ClassNotFoundException, SQLException {
		return AnswerDao.getInstance().insert(answers);
	}
	
}
