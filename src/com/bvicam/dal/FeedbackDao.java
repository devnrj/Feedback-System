package com.bvicam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bvicam.entity.Answer;
import com.bvicam.entity.AnswerOps;
import com.bvicam.entity.Feedback;
import com.bvicam.entity.Form;
import com.bvicam.entity.Student;
import com.bvicam.entity.User;
import com.bvicam.misc.ConnectionFactory;

public class FeedbackDao {
	private static FeedbackDao fd = null;
	private FeedbackDao() {
	}
	
	public static FeedbackDao getInstance() {
		synchronized(FormDao.class) {
			if(fd==null) {
				fd = new FeedbackDao();
			}
		}
		return fd;
	}
	
	public int countFeedbacks(Form fr) throws SQLException,ClassNotFoundException{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		int count=0;
		try{
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("select count(fk_form_id) from feedback_record");
			rs=pstmt.executeQuery();
			count=rs.getInt(1);
		}finally {
			if(rs!=null) 	{	rs.close();		}
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return count;
	}
	
	public ArrayList<Feedback> read(Object o) throws SQLException,ClassNotFoundException{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		ArrayList<Feedback> feedbacks = new ArrayList<>();
		try{
			conn=ConnectionFactory.getInstance().getConnection();
			if(o instanceof Form && o !=null) {
				Form fr = (Form) o;
				pstmt=conn.prepareStatement("select * from feedback_record where fk_form_id=?");
				pstmt.setInt(1, fr.getFormId());
			}else if(o instanceof Student && o !=null) {
				Student usr = (Student) o;
				pstmt=conn.prepareStatement("select * from feedback_record where fk_student_id=?");
				pstmt.setInt(1, usr.getId());
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ArrayList<Answer> answers =new ArrayList<>();	// <-- get answers for current feedback
				Feedback fd = new Feedback(rs.getInt(1),rs.getInt(2),rs.getString(5),
						rs.getInt(6),rs.getInt(3),answers,rs.getTimestamp(4));
				feedbacks.add(fd);
			}
		}finally {
			if(rs!=null) 	{	rs.close();		}
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return feedbacks;
	} 
	public int create(Feedback feedback) throws SQLException, ClassNotFoundException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("insert into feedback_record(fk_student_id,fk_form_id,"
					+ "feedback_status)");
			pstmt.setInt(1, feedback.getRollno());
			pstmt.setInt(2, feedback.getFormid());
			pstmt.setString(3,feedback.getStatus());
			pstmt.executeUpdate();
		}finally {
			if(rs!=null) 	{	rs.close();		}
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return count;
	}
	public int update(Feedback feedback) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("update table feedback_record set feedback_update_time = ? feedback_status=?"
					+ "feedback_score");
			pstmt.setTimestamp(1, feedback.getTime());
			pstmt.setString(2, feedback.getStatus());
			pstmt.setInt(3, feedback.getScore());
			count=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return count;
	}
	public int delete(Feedback feedback) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("delete from feedback_record where feedback_id=? or "
					+ "student_id=? or form_id=?");
			pstmt.setInt(1, feedback.getFid());
			pstmt.setInt(2, feedback.getRollno());
			pstmt.setInt(3, feedback.getFormid());
			count=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return count;
	}
}
