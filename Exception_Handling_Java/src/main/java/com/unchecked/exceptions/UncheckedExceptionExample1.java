package com.unchecked.exceptions;

import java.util.Scanner;

public class UncheckedExceptionExample1 {

	public static void main(String[] args) {

		System.out.println("program is started");
		
		 Scanner scanner = new Scanner(System.in);
//		 System.out.println("Enter a number:");
		 
//		 Example1:java.lang.Arithmetic Exception
//		 int numberInput=scanner.nextInt();
//		System.out.println(100/numberInput);
//			
//		->//user is giving 0 so exception accurs bcz of user//so remaining code is not priinting
//			
//		 Example 2:ArrayIndexOitofBoundException
//		 int[] arrayInt= new int[5];
//		 System.out.println("Enter the position (0-4)");
//		 int pos=scanner.nextInt();
//		 System.out.println("Enter a value");
//		 int value=scanner.nextInt();
//		 
//		 arrayInt[pos]=value;
//		 System.out.println(arrayInt[pos]);
		 
//		->user is giving  pos 5 so exception accurs bcz of user//so remaining code is not priinting

		 
//		 Example 3:java.lang.NumberFormatException:
//		 String s="215627";
//		 System.out.println("Enter a string to convert to Int");
//		 String s=scanner.next();
//		 int num=Integer.parseInt(s);
//		 System.out.println(num);
		 
//		 Example 4:java.lang.NullPointerException
		 
		 System.out.println("Enter a string to find its length");
		 
		 String s1=scanner.next();//->check
//		 String s1=null;
		 int lengthofString=s1.length();
		 System.out.println(lengthofString);
		System.out.println("program is ended");
		
	}

}
