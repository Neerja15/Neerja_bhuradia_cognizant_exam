package com.cts.training.test;

import java.util.ArrayList;

public class ArrayListExam{
    
	String name;
	int grades;
	public static void main(String args[]) {
		ArrayList<Student2> list=new ArrayList<>();
		
		Student2 s1=new Student2("Kratika",85);
		Student2 s2=new Student2("Tanishq",49);
		Student2 s3=new Student2("Nirali",75);
		Student2 s4=new Student2("Priya",89);
		Student2 s5=new Student2("Yash",58);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		
		
		Check(s1);
		Check(s2);
		Check(s3);
		Check(s4);
		Check(s5);
	
		
		
	}
	public static void Check(Student2 s)
	{
		if(s.getGrades()>=80)
			 System.out.println(s.getName()+" got Distinction");
		else if(s.getGrades()<80 && s.getGrades()>=60)
			    System.out.println(s.getName()+" got A grade");
		else if(s.getGrades()<60 && s.getGrades()>=50)
			    System.out.println(s.getName()+" got B grade");
		else 
			System.out.println(s.getName()+" is Fail");
	}
	
	
	
}
