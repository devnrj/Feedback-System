package com.bvicam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bvicam.entity.Form;
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
	
}
