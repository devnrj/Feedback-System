package com.bvicam.entity;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bvicam.dal.AnswerDao;
import com.bvicam.dal.FeedbackDao;


public class FeedbackOps {
	
	public int create(Feedback feedback) throws ClassNotFoundException, SQLException {
		if(feedback == null) {
			return -1;
		}
		return FeedbackDao.getInstance().create(feedback);
	}
	public ArrayList<Feedback> read(Object f) throws ClassNotFoundException, SQLException{
		ArrayList<Feedback> feedbacks=FeedbackDao.getInstance().read(f);
		return feedbacks;
	}
	public int update(Feedback feedback) throws ClassNotFoundException, SQLException {
		if(feedback == null) {
			return -1;
		}else if(feedback.getTime().equals(null) && feedback.getStatus().equals(null) || 
				feedback.getStatus().trim().equals("")) {
			return -1;
		}
		return FeedbackDao.getInstance().update(feedback);	
	}
	public int delete(Feedback feedback) throws ClassNotFoundException, SQLException {
		if(feedback == null) {
			return -1;
		}
		Answer ans = new Answer(0,feedback.getFid());
		AnswerDao.getInstance().delete(ans);
		return FeedbackDao.getInstance().delete(feedback);	
	}
}
