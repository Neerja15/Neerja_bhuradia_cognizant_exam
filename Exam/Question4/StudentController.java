package com.cts.training.ques4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class StudentController {
	public static void main(String[] args) throws NumberFormatException, IOException {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			QuestionFourth_1 td =new QuestionFourth_1();
			List<Student> list = td.getAllStudent();
			System.out.println("Enter Student rollno");
			int id = Integer.parseInt(br.readLine());
			System.out.println("Enter student Name");
			String nm = br.readLine();
			System.out.println("Enter student marks in english");
			int en = Integer.parseInt(br.readLine());
			System.out.println("Enter student marks in maths");
			int mt = Integer.parseInt(br.readLine());
			System.out.println("Enter student marks in science");
			int sc = Integer.parseInt(br.readLine());
			
			Student std = new Student(id, nm, en,mt,sc);
			td.addStudent(std);
	
			System.out.println(" display detais of all student");
			System.out.println("Details:");
			list.forEach(System.out::println);
			
		
		
		}
}
