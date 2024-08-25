package com.threads.java;

public class ThreadInternalCommunication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetPutClass getputobj = new GetPutClass();

		new ThreadNew1(getputobj);
		new ThreadNew2(getputobj);
	}

}

class GetPutClass {
	int num;
	boolean valueSet = false;

	public synchronized void put(int num) {// whenever you say wait we need to make the method sync
		while (valueSet) {// if it is set wait
			try {
				wait();// whe you say wait we are not specifyinh=g the time so thgread 1 is waiting
						// other should notify

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("put: " + num);
		this.num = num;
		valueSet = true;
		notify();
	}

	public synchronized void get() {
		while (!valueSet) {// if it is not set wait for the put method to put
			try {
				wait();// whe you say wait we are not specifyinh=g the time so thgread 1 is waiting
						// other should notify
                      //wait and notify works with object so it belongs to object class not thrrad class
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("get: " + num);
		valueSet = false;
		notify();
	}
}

class Count {
	int count;

	public void counter() {
		count++;
	}
}

class ThreadNew1 implements Runnable {
	GetPutClass obj;

	ThreadNew1(GetPutClass obj) {
		this.obj = obj;
		Thread th = new Thread(this, "Thead1");
		th.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while (true) {
			obj.put(i++);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}

class ThreadNew2 implements Runnable {
	GetPutClass obj;

	ThreadNew2(GetPutClass obj) {
		this.obj = obj;
		Thread th = new Thread(this, "Thead2");
		th.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			obj.get();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}