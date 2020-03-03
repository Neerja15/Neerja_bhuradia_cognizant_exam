package com.cts.training.ques4;
import java.util.ArrayList;
import java.util.List;
public class QuestionFourth_1 {
		
		
		ArrayList<Student> students = null;
		{	students = new ArrayList<>();
			Student std1 = new Student(1, "Vijay", 50, 60, 70);
			students.add(std1);
			Student std2 = new Student(2, "Ram", 50, 60, 70);
			students.add(std2);
			Student std3 = new Student(3, "Shayam", 50, 60, 70);
			students.add(std3);
				
		}
		public void addStudent(Student student){
			students.add(student);
		}
		public List<Student> getAllStudent() 
		{
			return students;
		}
}

	​
	​
		
		
		

