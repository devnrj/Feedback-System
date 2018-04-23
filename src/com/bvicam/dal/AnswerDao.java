package com.bvicam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import com.bvicam.entity.Answer;
import com.bvicam.entity.Feedback;
import com.bvicam.entity.QuesOps;
import com.bvicam.entity.Question;
import com.bvicam.misc.ConnectionFactory;

public class AnswerDao {
	private static AnswerDao fd = null;
	private AnswerDao() {
	}
	
	public static AnswerDao getInstance() {
		synchronized(FormDao.class) {
			if(fd==null) {
				fd = new AnswerDao();
			}
		}
		return fd;
	}
	//insert answer
	public int insert(ArrayList<Answer> as) throws SQLException, ClassNotFoundException {
		int count=0;
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			for(Answer ans : as) {
				Question qs = QuesOps.getInstance().getQuestionById(ans.getQid());
				if(qs.getType().toString().toLowerCase(Locale.ENGLISH).equals("mcq")) {
					pstmt=conn.prepareStatement("insert into feedback_answer(answer_id,fk_feedback_id,"
							+ "fk_ques_id,answer_mcq) values(?,?,?,?)");
					pstmt.setString(4,String.valueOf(ans.getMcq()));	
				}else if(qs.getType().toString().toLowerCase(Locale.ENGLISH).equals("text")) {
					pstmt=conn.prepareStatement("insert into feedback_answer(answer_id,fk_feedback_id,"
							+ "fk_ques_id,answer_text) values(?,?,?,?)");
					pstmt.setString(4,ans.getText());
				}	
				pstmt.setInt(1,ans.getAid());
				pstmt.setInt(2,ans.getFid());
				pstmt.setInt(3,ans.getQid());
				count+=pstmt.executeUpdate();
			}
		}finally {
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return count;
	}
	public ArrayList<Answer> read(Answer ans) throws ClassNotFoundException, SQLException{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		ArrayList<Answer> answers = new ArrayList<>();
		try{
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("select * from feedback_answer where answer_id = ? or fk_feedback_id = ? or "
					+ "fk_ques_id=?");
			pstmt.setInt(1, ans.getAid());
			pstmt.setInt(2, ans.getFid());
			pstmt.setInt(3, ans.getQid());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Answer ansfromdb = new Answer(rs.getInt(1),rs.getInt(2),rs.getInt(3),
						rs.getString(4).trim().charAt(0),rs.getString(5));
				answers.add(ansfromdb);
			}
		}finally {
			if(rs!=null)		{ 	rs.close();		}
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return answers;
	}
	public int update(Answer ans) throws ClassNotFoundException, SQLException {
		int count=0;
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			Question qs = QuesOps.getInstance().getQuestionById(ans.getQid());
			if(qs.getType().toString().toLowerCase(Locale.ENGLISH).equals("mcq")) {
				pstmt=conn.prepareStatement("update feedback_answer set answer_mcq =? where answer_id=?");
				pstmt.setString(1,String.valueOf(ans.getMcq()));
				pstmt.setInt(2, ans.getAid());
			}else if(qs.getType().toString().toLowerCase(Locale.ENGLISH).equals("text")) {
				pstmt=conn.prepareStatement("update feedback_answer set answer_text =? where answer_id=?");
				pstmt.setString(1,ans.getText());
				pstmt.setInt(2,ans.getAid());
			}
		}finally {
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return count;
	}
	public int delete(Answer ans) throws ClassNotFoundException, SQLException {
		int count=0;
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("delete form feedback_answer where answer_id=? or fk_feedback_id=? ");
			pstmt.setInt(1, ans.getAid());
			pstmt.setInt(2, ans.getFid());
			count=pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return count;
	}

}
