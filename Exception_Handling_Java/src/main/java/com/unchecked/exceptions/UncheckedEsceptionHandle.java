package com.unchecked.exceptions;

import java.util.Scanner;

public class UncheckedEsceptionHandle {

	public static void main(String[] args) throws Exception {
		System.out.println("program is started");

		Scanner scanner = new Scanner(System.in);
//		 System.out.println("Enter a number:");

//		 Example1:Handline java.lang.Arithmetic Exception
////		 Example 2:
		int[] arrayInt = new int[5];
		System.out.println("Enter the position (0-4)");
		int pos = scanner.nextInt();
		System.out.println("Enter a value");
		
//		Example3
		
		System.out.println("Enter a string to find its length");

		try {
//		    int numberInput=scanner.nextInt();//->not in this line
//			System.out.println(100 / numberInput);// ->exception comes in this line(when we process the input)

			int value = scanner.nextInt();
			arrayInt[pos] = value;
			System.out.println(arrayInt[pos]);
//			
			 
//			 String s1=scanner.next();//->check
//			 String s1=null;
//			 int lengthofString=s1.length();
//			 System.out.println(lengthofString);
			//throw an exception manually
			throw new ArithmeticException("I am throwing the exception letting catchblock catch");
//			
		} catch (ArithmeticException ex) {
			System.out.println("invalid number" + ex);
		} catch (NumberFormatException ex) {
			System.out.println("invalid input" + ex.getMessage());
//		} catch (Exception ex) {
//			System.out.println("invalid input " + ex.getMessage());
		}
		finally {
			System.out.println("i dont care about exception");
		}
		  System.out.println("program is ended");
//

	}

}
