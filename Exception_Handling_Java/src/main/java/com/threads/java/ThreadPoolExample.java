package com.threads.java;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {

	public static void main(String[] args) {
//  step1: create Thread pool object

		ThreadPoolExecutor executer = new ThreadPoolExecutor(2, 4, 1, TimeUnit.MINUTES,
				new ArrayBlockingQueue<Runnable>(2), new CustomThreadFactory(),
//				new ThreadPoolExecutor.DiscardPolicy(),//line 19 instead of this
				new CusomRejectHandler());
//		for (int i = 0; i < 4; i++) {// 4 task
//			o/p:
//			Task processed by Thread-1
//			Task processed by Thread-0
//			Task processed by Thread-0
//			Task processed by Thread-1
//			what if task 5 comes?
//			now new thraed is created
//		for (int i = 0; i < 6; i++) {// 5 task->>creating one more 3rd thraed, max is 4 fine
//		    o/p:
//			Task processed by Thread-0
//			Task processed by Thread-1
//			Task processed by Thread-2
//			Task processed by Thread-0
//			Task processed by Thread-1 
		
		
//		for (int i = 0; i < 6; i++) {// 6 task->creating one more 4th thraed ,max is 4 fine
//			o/p:
//			Task processed by Thread-3
//			Task processed by Thread-2
//			Task processed by Thread-0
//			Task processed by Thread-1
//			Task processed by Thread-0
//			Task processed by Thread-3
			executer.allowCoreThreadTimeOut(true);
		for (int i = 0; i < 7; i++) {// 7 task->cant create thraed ,thread is max 4 already

			executer.submit(() -> {// submmiting(runnable state)
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("Task processed by " + Thread.currentThread().getName());
			});
		}
		executer.shutdown();//once doen shutdown

	}

}
//step 2if ypu wamt  you can use custom threadfactory

class CustomThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread th = new Thread(r);
		th.setPriority(Thread.NORM_PRIORITY);
		th.setDaemon(false);
		return th;
	}

}
//step 3: if ypu wamt  you can use custom RejectHandler


class CusomRejectHandler implements RejectedExecutionHandler {
// adding logs 
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		System.out.println("task rejected" + r.toString());
	}

}