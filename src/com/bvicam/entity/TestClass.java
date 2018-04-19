package com.bvicam.entity;

import java.sql.SQLException;

import com.bvicam.dal.FormDao;

public class TestClass {

	public static void main(String[] args) throws SQLException,ClassNotFoundException{
//		UserDao ud = UserDao.getInstance();
//		ud.listUsers();
//		QuesOps.getInstance().loadQuestions();
//		ArrayList<Question> al = QuesOps.getInstance().getQuestionList();
//		al.forEach(ques -> System.out.println(ques));
//		QuesUsage qu = QuesUsage.valueOf("institute".toUpperCase(Locale.ENGLISH));
//		al=QuesOps.getInstance().getQuestions(qu);
//		System.out.println("Filtered Question");
//		al.forEach(ques-> System.out.println(ques));
//		Form f = new Form(111);
//		System.out.println("Enter details to create a form");
//		System.out.println("Enter Subject ID:");
//		f.setFormSubId(44101);
//		System.out.println("Teacher ID:");
//		f.setFormTeacherId(11235);
//		System.out.println("Form ID:");
//		
//		System.out.println("Form Name:");
//		f.setFormName("Basic");
//		System.out.println("Feedback Tracker Id");
//		f.setFormTrackerId(2);
//		f.setFormStatus("active");
//		System.out.println("");
//		f.setQuestions(al);
//		FormOperations fo = new FormOperations();
//		fo.create(f);
//		
		
		
		FormDao fd =FormDao.getInstance();
		Form fr = new Form(1);
		fr.setFormSubId(44101);
		fr.setFormName("Neeraj");
		fd.update(fr);
	}

}
