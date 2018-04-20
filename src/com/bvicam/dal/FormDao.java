package com.bvicam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.bvicam.entity.Form;
import com.bvicam.entity.Question;
import com.bvicam.misc.ConnectionFactory;

public class FormDao {
	private static FormDao fd = null;
	private FormDao() {
	}
	public static FormDao getInstance() {
		synchronized(FormDao.class) {
			if(fd==null) {
				fd = new FormDao();
			}
		}
		return fd;
	}
	
	public void insert(Form fr) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Question> al = fr.getQuestions();
		Iterator<Question> it = al.iterator();
		int i = 0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("insert into FeedbackSystem.form(form_name,fk_form_subject,"
					+ "fk_form_teacher,form_status,fk_tracker_id) values(?,?,?,?,?)");
			pstmt.setString(1,fr.getFormName());
			pstmt.setInt(2,fr.getFormSubId());
			pstmt.setInt(3,fr.getFormTeacherId());
			pstmt.setString(4, fr.getFormStatus());
			pstmt.setInt(5, fr.getFormTrackerId());
			pstmt.executeUpdate();
			int x=0;
			while(it.hasNext()) {
				pstmt=conn.prepareStatement("insert into FeedbackSystem.mt_form_question(fq_form_id,"
						+ "fq_ques_id) values(?,?)");
				pstmt.setInt(1,fr.getFormId());
				pstmt.setInt(2, al.get(i).getQuesId());
				x=pstmt.executeUpdate();
				System.out.println(x+"rows updated");
				it.next();
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) 	{	rs.close();		}
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
	}
	
	public int update(Form fr) throws SQLException{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int counter = 0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("update FeedbackSystem.form set form_name=? form_status=?");
			pstmt.setString(1,fr.getFormName());
			pstmt.setString(2, fr.getFormStatus());
			counter = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) 	{	rs.close();		}
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return counter;
	}
	
	public ArrayList<Form> read(Form f) throws SQLException,ClassNotFoundException{
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<Form> match_forms = new ArrayList<>();
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			pstmt = conn.prepareStatement("select * from form where form_id=? or form_name=? or fk_form_subject=? or fk_form_teacher=? or fk_tracker_id =? or form_status=?");
			pstmt.setInt(1, f.getFormId());
			pstmt.setString(2,f.getFormName());
			pstmt.setInt(3, f.getFormSubId());
			pstmt.setInt(4, f.getFormTeacherId());
			pstmt.setInt(5, f.getFormTrackerId());
			pstmt.setString(6, f.getFormStatus());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Form fr = new Form(rs.getInt(1),rs.getInt(4),rs.getInt(3),rs.getString(2),rs.getString(6),rs.getInt(5));
				match_forms.add(fr);
			}
		}finally {
			if(rs!=null) 	{	rs.close();		}
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return match_forms;
	}
	
	public int delete(Form fr) throws SQLException,ClassNotFoundException{
		Connection conn = null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			//1. check if any feedback uses this form then don't delete.
			if(FeedbackDao.getInstance().countFeedbacks(fr)==0) {
				return 0;
			}else {
			//2. delete question mapping from mt_form_question.
			pstmt=conn.prepareStatement("delete from mt_form_question where form_id=?");
			pstmt.setInt(1, fr.getFormId());
			pstmt.executeUpdate();
			pstmt.close();
			//3. delete form
			pstmt=conn.prepareStatement("delete from form where form_id=?");
			pstmt.setInt(1, fr.getFormId());
			count=pstmt.executeUpdate();
			}
		}finally {
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return count;
	}
}
