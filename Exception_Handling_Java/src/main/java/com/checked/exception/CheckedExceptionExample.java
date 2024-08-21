package com.checked.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExceptionExample {

//	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
	public static void main(String[] args) throws Exception {

		System.out.println("program started");
//once you executed the prpgram,some memory allocated a dprocessrunning
		//when you to give thread.sleep it will pause and execute
		//so if another process also running and executes in the same memory(may be mmry bot suffu)
//		it might interuptt so compiler is telling us to handle tis
		
//		checked exception examp
		
		FileInputStream file=new FileInputStream("C:\\somefile.txt");
		//the above line will show handle this if the file not exist it mght give file not found exception
		Thread.sleep(5000);
//
//		try {
//		Thread.sleep(5000);
//		}catch(InterruptedException ex) {
//			System.out.println(ex);
//		}
		//we can try block also  for checked exception
		System.out.println("program continues");
		System.out.println("program ended");
	}

}
