package com.bvicam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import com.bvicam.entity.QuesType;
import com.bvicam.entity.QuesUsage;
import com.bvicam.entity.Question;
import com.bvicam.misc.ConnectionFactory;

public class QuesDao{
	private static QuesDao qd= null;
	private QuesDao() {
	}
	public static QuesDao getInstance() {
		synchronized(QuesDao.class) {
			if(qd==null) {
				qd= new QuesDao();
			}
		}
		return qd;
	}
	public ArrayList<Question> getQuestions() throws ClassNotFoundException, SQLException{
		Connection conn = null; 
		PreparedStatement stmt = null;
		ResultSet rs= null;
		Question qs;
		ArrayList<Question> qList = new ArrayList<>();
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			stmt=conn.prepareStatement("Select * from question");
			rs=stmt.executeQuery();
			if(!rs.next()) {
				System.out.println("No records found");
			}
			while(rs.next()) {
				qs = new Question();
				int qid= Integer.parseInt(rs.getString("ques_id"));
				String qname=rs.getString("ques_name");
				String qtype = rs.getString("ques_type");
				String quse=rs.getString("ques_usage");
				qs.setQuesId(qid);
				qs.setQuesName(qname);
				qs.setType(QuesType.valueOf(qtype.toUpperCase(Locale.ENGLISH)));
				qs.setQuesUsage(QuesUsage.valueOf(quse.toUpperCase(Locale.ENGLISH)));
				qList.add(qs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return qList;
	}
	
	public Question getQuestion(int qid) throws ClassNotFoundException, SQLException{
		Connection conn = null; 
		PreparedStatement stmt = null;
		ResultSet rs= null;
		Question qs=null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			stmt=conn.prepareStatement("Select * from question where ques_id = ?");
			stmt.setInt(1, qid);
			rs=stmt.executeQuery();
			if(!rs.next()) {
				System.out.println("No records found");
			}
			qs = new Question();
			int quesid= Integer.parseInt(rs.getString("ques_id"));
			String qname=rs.getString("ques_name");
			String qtype = rs.getString("ques_type");
			String quse=rs.getString("ques_usage");
			qs.setQuesId(quesid);
			qs.setQuesName(qname);
			qs.setType(QuesType.valueOf(qtype.toUpperCase(Locale.ENGLISH)));
			qs.setQuesUsage(QuesUsage.valueOf(quse.toUpperCase(Locale.ENGLISH)));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)		{	rs.close();		}
			if(stmt!=null)	{	stmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return qs;
	}
	//add question
	//update question
	//delete question
}
