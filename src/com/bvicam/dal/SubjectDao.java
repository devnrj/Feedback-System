package com.bvicam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bvicam.entity.Subject;
import com.bvicam.misc.ConnectionFactory;

public class SubjectDao {
	private static SubjectDao fd = null;
	private SubjectDao() {
	}
	public static SubjectDao getInstance() {
		if(fd==null) {
			synchronized(SubjectDao.class) {
				if(fd==null) {
					fd = new SubjectDao();
				}
			}
		}
		return fd;
	}
	public ArrayList<Subject> readSubject(Subject sub) throws SQLException , ClassNotFoundException{
		Connection conn=null;
		PreparedStatement ps= null;
		ArrayList<Subject> subjects=new ArrayList();
		ResultSet rs=null;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			ps=conn.prepareStatement("select * from subject where subject_id=? subject_name=? subject_code=? subject_status=? subject_type=?");
			rs=ps.executeQuery();
			while(rs.next()) {
				int subject_id=rs.getInt(1); 
				String subject_name=rs.getString(2); 
				int subject_code=rs.getInt(3); 
				String subject_status=rs.getString(4);
				String subject_type=rs.getString(5);
				Subject s = new Subject(subject_id,subject_name,subject_code,subject_status,subject_type);
				subjects.add(s);
			}
		}catch(Exception e) { e.printStackTrace(); }
		finally{
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return subjects;
	}
}
