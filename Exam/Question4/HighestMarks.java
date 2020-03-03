
//4.2

package com.cts.training.test.ques;
import java.util.ArrayList;
import java.util.Scanner;


public class HighestMarks {
private double mark;
		private String name;
		public static void main(String[] args) {
			ArrayList<Student1> studs = new ArrayList<Student1>();
			for (int i = 0; i < 3; i++) {
				studs.add(new Student1());
			}
			Scanner sc = new Scanner(System.in);
			double max;
			int i;
			for (i = 0; i < 3; i++) {
				System.out.println("Enter name of student: ");
				studs.get(i).setName(sc.nextLine());
				System.out.println("Enter marks: ");
				studs.get(i).setGrades(sc.nextInt());
				sc.nextLine();
			}
			int position = 0;
			max = studs.get(0).getGrades();
			for (i = 0; i < 3; i++) {
				if (max < studs.get(i).getGrades()) {
					max = studs.get(i).getGrades();
					position = i;
				}
			}
			System.out.println(
					"Highest marks:" + studs.get(position).getGrades() + " student name " + studs.get(position).getName());
		}
		public HighestMarks() {
			mark = 0;
			name = "";
		}
		public HighestMarks(int mark, String name) {
			this.mark = mark;
			this.name = name;
		}
		public double getMark() {
			return mark;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setMark(double mark) {
			this.mark = mark;
		}

}
