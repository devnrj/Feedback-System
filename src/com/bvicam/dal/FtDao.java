package com.bvicam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bvicam.entity.FeedbackTracker;
import com.bvicam.misc.ConnectionFactory;

public class FtDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		return ConnectionFactory.getInstance().getConnection();
	}
	
	public void addTracker(FeedbackTracker ftr) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn=this.getConnection();
			pstmt=conn.prepareStatement("insert into FeedbackSystem.feedback_tracker(batch,semester,"
					+ "ft_start_date,ft_end_date,ft_critical_date,section) values(?,?,?,?,?,?)");
			pstmt.setString(1, ftr.getBatchYear());
			pstmt.setInt(2, ftr.getSemester());
			pstmt.setDate(3, ftr.getStartDate());
			pstmt.setDate(4, ftr.getEndDate());
			pstmt.setDate(5, ftr.getCriticalDate());
			pstmt.setInt(6, ftr.getSection());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("Record written");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		
	}
}
