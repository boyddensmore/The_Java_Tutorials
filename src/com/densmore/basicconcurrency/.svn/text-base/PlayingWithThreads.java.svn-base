package com.densmore.basicconcurrency;

public class PlayingWithThreads {

	// Display a message, preceded by
	// the name of the current thread
	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}
	
	private static class ThreadToRun implements Runnable{
		public void run(){
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(1000);
					threadMessage(Integer.toString(i));
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
	}
	
//	PlayingWithThreads main method.
	public static void main(String[] args) {

		Thread t1 = new Thread(new ThreadToRun());
		Thread t2 = new Thread(new ThreadToRun());
		Thread t3 = new Thread(new ThreadToRun());
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
