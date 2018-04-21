package com.bvicam.entity;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bvicam.dal.FeedbackDao;


public class FeedbackOps {
	
	public int create(Feedback feed) {
		
		return 0;
	}
	public ArrayList<Feedback> read(Object f) throws ClassNotFoundException, SQLException{
		ArrayList<Feedback> feedbacks=FeedbackDao.getInstance().read(f);
		return feedbacks;
	}
}
