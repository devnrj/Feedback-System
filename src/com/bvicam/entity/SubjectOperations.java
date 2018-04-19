package com.bvicam.entity;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bvicam.dal.SubjectDao;

public class SubjectOperations {
	public ArrayList<Subject> read(Subject sub) throws ClassNotFoundException, SQLException {
		ArrayList<Subject> sb =SubjectDao.getInstance().readSubject(sub);
		System.out.println(sb);
		return sb;
	}
	
	public static boolean isGeneral(Subject sub) {
		if(sub.getId() >= 44101 && sub.getId() <= 44362) {
			if(sub.getId() > 11104 && sub.getId() < 11101) {
				return false;
			}else {
				return true;
			}
			
		}
		return false;
	}
	
	public Subject getSubById(int id) throws ClassNotFoundException, SQLException {
		Subject sb = new Subject(id);
		for(Subject x : this.read(sb)) {
			if(sb.getId() == x.getId()) {
				sb=x;
			}
		}
		return sb;
	}
}
