package com.bvicam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bvicam.entity.User;
import com.bvicam.misc.ConnectionFactory;

public class UserDao {
	private static UserDao ud = null;
	
	private UserDao() {
	}
	
	public static UserDao getInstance() {
		synchronized(UserDao.class) {
			if(ud==null) {
				ud = new UserDao();
			}
		}
		return ud;
	}
	public void listUsers() throws ClassNotFoundException, SQLException{
		Connection conn = null; 
		PreparedStatement stmt = null;
		ResultSet rs= null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			stmt=conn.prepareStatement("Select user_id, user_name from user_mst");
			rs=stmt.executeQuery();
			while(rs.next()) {
				System.out.println("User ID:"+rs.getString("user_id")+
								   " User Name:"+ rs.getString("user_name"));
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
		
	}
	public int insert(User u) throws SQLException,ClassNotFoundException{
		Connection conn = null; 
		PreparedStatement pstmt = null;
		int x=0;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("insert into FeedbackSystem.user_mst(user_id,user_name,user_pass,user_email,"
					+ "user_contact,fk_user_role,user_gender,user_title,user_yoj,user_yol");
			x=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return x;
	}
}
