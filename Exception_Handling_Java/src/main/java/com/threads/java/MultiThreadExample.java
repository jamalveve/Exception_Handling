package com.threads.java;

public class MultiThreadExample {

	public static void main(String[] args) {
		System.out.println("=============APplication Started=================");
		Printer printer=new Printer();
//		printer.printDocument(10, "ishans Profile");
		//scaneraio 1
//		//in the above scenario w can call only one time with one obje if you want to wprk mpre on it
//		//we haev to create tyheb below but still secod one need to wait for fortsy one to complete
//       
//		printer.printDocument(10, "samee Profile");
//		
		
		MyThreadnew mrf=new MyThreadnew(printer);
		YourThreadnew yrf=new YourThreadnew(printer);
		mrf.start();
//		try {
//		mrf.join();
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		//scenario 4:
	//so in the above case if 10 thread is using printer and need t =o be synchronised we cant give join between every thread so
//		we can synchronise the method itself line nmber->41
//		so comment join (no need) 
		yrf.start();
		//scenario 2:
		//scenario above is printer is shared betweem twpo threads
		//output will be mixed up
		//thread are aysnchronised
		
		//scenario 3:
//		so some scenarios might b there multiple threads might work on same task and it should be synchrnised
		//suing sleeo method in loop
		//still  not synchronised so use join meto=hod comes here in line nukber 19
		
		
		System.out.println("=============APplication Ended=================");

	}

}
class Printer{
	//ome way of synchronse-->making the method sybchrnise using sybchronized keyword
//	synchronized
	void printDocument(int numofCopies,String docName) {
		for(int i=0;i<=numofCopies;i++) {
			try {
			Thread.sleep(500);
			}catch(Exception e) {
				System.out.println(e);
			}
			System.out.println(">> printing the  "+docName+" "+i);
		}
	}
}
class MyThreadnew extends Thread{
	Printer rf;
	MyThreadnew(Printer p){//constructo0r
		rf=p;
	}
	
	public void run() {
		//second way using synchronize block
		synchronized (rf) {
			rf.printDocument(10, "john");
		}
//		rf.printDocument(10, "john");
	}
	
}
class YourThreadnew extends Thread{
	Printer rf;
	YourThreadnew(Printer p){//constructo0r
		rf=p;
	}
	
	public void run() {
		synchronized (rf) {
			rf.printDocument(10, "sihsnas");
		}
//		rf.printDocument(10, "ishans");
	}
	
}