package com.bvicam.entity;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bvicam.dal.FormDao;

public class FormOperations{
	
	public int create(Form o) {
			FormDao fd = FormDao.getInstance();
			try {
				fd.insert(o);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
	public Object read(Object o){
		return o;
	}
	
	public int update(Form o){
		FormDao fd = FormDao.getInstance();
		try {
			
		}finally {
			
		}
		
		return 0;
	}

	public void delete(Object o){
		
	}
	public void subChange(Form secodn) {
		
	}

}
