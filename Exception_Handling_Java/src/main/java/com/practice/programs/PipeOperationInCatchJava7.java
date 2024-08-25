package com.practice.programs;

public class PipeOperationInCatchJava7 {

	public static void main(String[] args) {

	    try {
            // Code that may throw multiple exceptions
            int result = 10 / 0; // This will cause ArithmeticException
            String str = null;
            str.length(); // This will cause NullPointerException
        } catch (ArithmeticException | NullPointerException e) {
        	System.out.println(e);
            System.out.println("An exception occurred: " + e.getMessage());
        }
	    
	    try {
            // Code that may throw multiple exceptions
	    	String str = null;
            str.length(); // This will cause NullPointerException
            int result = 10 / 0; // This will cause ArithmeticException
            
        } catch (ArithmeticException | NullPointerException e) {
        	System.out.println(e);
            System.out.println("An exception occurred: " + e.getMessage());
        }
	} 

}
