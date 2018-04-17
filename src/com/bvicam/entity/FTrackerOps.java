package com.bvicam.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class FTrackerOps {

	FeedbackTracker ftri=null;
	void create()
	{
		System.out.println("Enter Batch Year:");
		Scanner in  = new Scanner(System.in);
		String year = in.next();
		ftri.setBatchYear(year);
		System.out.println("Enter Semster :");
		int sem = in.nextInt();
		ftri.setSemester(sem);
		System.out.println("Enter Section :");
		int sec = in.nextInt();
		ftri.setSection(sec);
		System.out.println("Enter Critical date:");
		int ar[] = new int[3];
		String date=in.next();
		String sp[]=date.split("\\W");
		Calendar dt = Calendar.getInstance();
		dt.set(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), Integer.parseInt(sp[2]));
//		ftri.setCriticalDate(dt.getTime());
//		ftri.setStartDate("1");
//		ftri.setEndDate("10");		
//		
	}
	
	public void getFormList() {
		
	}
	
	void notifystudent()
	{ LocalDate localDate = LocalDate.now();
		if(ftri.getCriticalDate().equals(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate)))//DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate))
		{
			System.out.println("please fill the feedback form ");
		}
		else
		{
			System.out.println("kat gya "+DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate));
		}
	}
	
	void read(String param,FeedbackTracker ft){
		
		
	}
	void update()
	{
		
	}
	
}
