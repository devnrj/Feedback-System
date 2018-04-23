package com.bvicam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bvicam.entity.FeedbackTracker;
import com.bvicam.misc.ConnectionFactory;

public class FtDao {
	public int create(FeedbackTracker ftr) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt= null;
		int count=0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("insert into FeedbackSystem.feedback_tracker(batch,semester,"
					+ "ft_start_date,ft_end_date,ft_critical_date,section) values(?,?,?,?,?,?)");
			pstmt.setString(1, ftr.getBatchYear());
			pstmt.setInt(2, ftr.getSemester());
			pstmt.setDate(3, ftr.getStartDate());
			pstmt.setDate(4, ftr.getEndDate());
			pstmt.setDate(5, ftr.getCriticalDate());
			pstmt.setInt(6, ftr.getSection());
			count=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}	
		return count;
	}
	public int delete(FeedbackTracker ftracker) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		PreparedStatement pstmt= null;
		int count=0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("delete from feedback_tracker where ft_id=?");
			pstmt.setInt(1, ftracker.getfTrackerid());
			count=pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return count;
	}
	public int update(FeedbackTracker tracker) throws SQLException, ClassNotFoundException{
		Connection conn=null;
		PreparedStatement pstmt=null;
		int counter = 0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("update FeedbackSystem.feedback_tracker set batch=? semester=? ft_start_date"
					+ "ft_end_date=? ft_critical_date=? section=?");
			pstmt.setString(1,tracker.getBatchYear());
			pstmt.setInt(2,tracker.getSemester());
			pstmt.setDate(3, tracker.getStartDate());
			pstmt.setDate(4, tracker.getEndDate());
			pstmt.setDate(5, tracker.getCriticalDate());
			pstmt.setInt(6,tracker.getSection());
			counter = pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return counter;
	}
	
	public ArrayList<FeedbackTracker> read(FeedbackTracker tracker) throws ClassNotFoundException, SQLException{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<FeedbackTracker> trackers = new ArrayList<>();
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			pstmt=conn.prepareStatement("select * from feedback_tracker where ft_id=? or batch=? or semester=? or"
					+ "ft_start_date=? or ft_end_date=? or ft_critical_date=? or section=?");
			pstmt.setInt(1, tracker.getfTrackerid());
			pstmt.setString(2, tracker.getBatchYear());
			pstmt.setInt(3, tracker.getSemester());
			pstmt.setDate(4, tracker.getStartDate());
			pstmt.setDate(5, tracker.getEndDate());
			pstmt.setDate(6, tracker.getCriticalDate());
			pstmt.setInt(7, tracker.getSection());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				FeedbackTracker ft = new FeedbackTracker(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4),
						rs.getDate(5),rs.getDate(6),rs.getInt(7));
				trackers.add(ft);
			}
		}finally {
			if(rs!=null)		{	rs.close();		}
			if(pstmt!=null)	{	pstmt.close();	}
			if(conn!=null)	{	conn.close();	}
		}
		return trackers;
	}
	
}
