package com.threads.java;

public class ThreadExamplebyThreadClass {
	//main method here rep main thread
		//threads always executes its job in a sequence order
	public static void main(String[] args) {
		
//		job 1
		System.out.println("========Application Started");
		
////		job 2
//		MyTask mytask=new MyTask();
//		mytask.executeTask();
		
//		/in this case job 3 have to wait for job 2 to complete if job two is long processss it have to wait and 
		//in such situation app is not responding we can see
		// and it sluggish behvaiour ( a hang)
		//this is a usecase where custom thread is needed
		
//		now job 2 replaced by thread	
		MyTask mytask=new MyTask();
		mytask.start();
		
		//so here we can see job 2 and job 3->will print parellely on concurrently 
//		//everytime whenevr we execute it is mixed 
		//now main and my task are parlly/concurrently
		//and main taksk will  not hang ,it wont affect bcz of mytask it is running separate separatelly
		//we can tell child thread /worker thread
		
		
//		job 3
		for (int doc=0;doc<=10;doc++) {
			System.out.println("printing the documemt: "+doc+" -printer1");
		}
		
		
//		job 4
		System.out.println("========Application ended");

		
	}

}
//class MyTask{
//	void executeTask() {
//		for (int doc=0;doc<=10;doc++) {
//			System.out.println("printing the documemt: "+doc+" -printer2");
//		}
//	}
//}
class MyTask extends Thread{ //but here the draw back is multiple inheritance is not possible
	public void run() {
		for (int doc=0;doc<=10;doc++) {
			System.out.println("printing the documemt through thread: "+doc+" -printer2");
		}
	}
}
