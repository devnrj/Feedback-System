package com.bvicam.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class FRecOps {

	ArrayList<FeedbackRecord> frlist=new ArrayList<>();
	FeedbackRecord fr = new FeedbackRecord();
	
	void show()
	{
		System.out.println("hii varun");
	//	FormTemplate ft=new FormTemplate();
		
	}
	
	void providefeedback()
	{
		
	}
	
	@Override
	public String toString() {
		return "FrOperations [frlist=" + frlist + ", fr=" + fr + "]";
	}

	void read()
	{
		
		System.out.println(frlist);
	//	System.out.print(answer);
	}
	
	void set()
	{
		fr.setForm_id(001);
		//System.out.println("fgdfg");
		fr.setFr_id(012);
		fr.setRollno(024);
		fr.setSubject_id(140);
		frlist.add(fr);
		
	}
	
	
	void update()
	{    Scanner  in = new Scanner(System.in);
		 System.out.println("your answer");
		 String ans= in.nextLine();
		 fr.setAnswer(ans);
		 
		 System.out.println("updated..");
			read();
		
		
	}
	void linkform()
	{
		Form FormOpr = new Form();
//		FormOpr.create();
//		FormOpr.read();
//		FormOpr.update();
//		FormOpr.delete();
//		FormOpr.assignTeacher();
	//	FormOpr.assignSubject();
	}
}
