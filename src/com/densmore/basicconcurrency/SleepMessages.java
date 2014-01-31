package com.densmore.basicconcurrency;

public class SleepMessages {
	public static void main(String args[]) throws InterruptedException {
		String importantInfo[] = { "Mares eat oats", "Does eat oats",
				"Little lambs eat ivy", "A kid will eat ivy too" };

		for (int i = 0; i < importantInfo.length; i++) {
//			Pause for 1 second
//			In this case, we're not creating a separate thread, so we're 
//			just making the initial thread sleep.  Calling Thread.sleep just 
//			puts the main process thread to sleep.
			Thread.sleep(1000);
			// Print a message
			System.out.println(importantInfo[i]);
		}
	}
}