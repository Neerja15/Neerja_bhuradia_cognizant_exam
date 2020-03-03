package com.cts.training.test;
import java.util.Scanner;


	public class Number {
		public void two(int num){
		
			int original=num;
			int rem=0;
			int div=0;
			 int result=0;
			
			 for(int i=0;i<2;i++)
			 {
				rem=num%10;
				 div=num/10;
				 if(rem>div)
				 result=rem-div;
				 else
					 result=div-rem;
			 }
		
			System.out.println(result+""+rem);
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println("Enter the two consecutive only for Two Digit ");
			Scanner Sc=new Scanner(System.in);
			int num =Sc.nextInt();
			Number j=new Number();
			j.two(num);
		}
	}