package com.practice.programs;

import java.util.Scanner;

public class FinallywontWorkExample {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
		try {
//			Scanner scann=new Scanner(System.in);
//			int s=scann.nextInt();
			Thread.sleep(10000);
          //2)
//			System.exit(0);

		}catch(Exception e){
			System.out.println(e);
		}
		finally {
			System.out.println("will i execute?");//no
			//1) throw new RuntimeException("Simulated JVM crash");
			
//			//3) while (true) {
//				 System.out.println("unclosed loop");
//	            }
		}
    });

    thread.start();
    Thread.sleep(1000); // Allow thread to start
    thread.interrupt(); //
	}

}
