package com.bankht.monkey.thread;

class TestThreadMethod extends Thread {
	public int shareVar = 0;
	public Notifier notifier;

	public TestThreadMethod(String name) {
		super(name);
		notifier = new Notifier(this);
	}

	public synchronized void run() {
		if (shareVar == 0) {
			for (int i = 0; i < 5; i++) {
				shareVar++;
				System.out.println("i = " + shareVar);
				try {
					System.out.println("wait......");
					this.wait();
				} catch (InterruptedException e) {
				}
			}
			
			notifier.setCount(5);
		}
	}
}

class Notifier extends Thread {
	private TestThreadMethod ttm;

	private int count = 0;

	Notifier(TestThreadMethod t) {
		ttm = t;
		start();
	}
	
	public void setCount(int count){
		this.count = count;
	}

	public void run() {
		while (count < 5) {
			try {
				sleep(2000);
			} catch (InterruptedException e) {
			}
			/* 1 要同步的不是当前对象的做法 */
			synchronized (ttm) {
				System.out.println("notify......");
				ttm.notify();
			}
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		TestThreadMethod t1 = new TestThreadMethod("t1");
		t1.start();
	}
}
