/**
 * 
 */
package com.bankht.monkey.thread;


/**
 * extend Thread的测试
 * 如果自己定义了有参数的Constructor话，那么默认无参数的就不会被创建
 * @author Monkey
 *
 */
public class ThreadExtendThread extends Thread {
	int time;
	String showName;
	
	public ThreadExtendThread(int time, String showName){
		this.time = time;
		this.showName = showName;
	}
	
	public void run(){
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
		ThreadExtendThread tetA = new ThreadExtendThread(1000, "A");
		tetA.start();
		ThreadExtendThread tetB = new ThreadExtendThread(2000, "B");
		tetB.start();
		ThreadExtendThread tetC = new ThreadExtendThread(3000, "C");
		tetC.start();
	}

}
