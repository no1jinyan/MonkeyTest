/**
 * 
 */
package com.bankht.monkey.thread;

/**
 * @author Monkey
 *
 */
public class ThreadImplRunnable implements Runnable {
	int time;
	String showName;
	
	public ThreadImplRunnable(int time, String showName){
		this.time = time;
		this.showName = showName;
	}
	
	public void run() {
		while(true){
			try {
				System.out.println("Thread name is " + showName);
				Thread.sleep(time);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread a = new Thread(new ThreadImplRunnable(1000, "A"));
		System.out.println("1."+a.getState());
		a.start();
		System.out.println("2." + a.getState());
	}

}
