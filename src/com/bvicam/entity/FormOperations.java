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
	public Form getFormById(int formid) throws ClassNotFoundException, SQLException {
		FormDao fd = FormDao.getInstance();
		ArrayList<Form> forms = fd.read(new Form(formid));
		for(Form temp:forms) {
			if(formid == temp.getFormId()) {
				return temp;
			}
		}
		return null;
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
	public void read(Form second) {
		
	}

}
