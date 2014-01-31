package com.densmore.basicconcurrency;

public class Inturruptions {
	public static void main(String args[]) throws InterruptedException {
		String importantInfo[] = { "Mares eat oats", "Does eat oats",
				"Little lambs eat ivy", "A kid will eat ivy too" };

		for (int i = 0; i < importantInfo.length; i++) {
			try {
				Thread.sleep(1000);
				
				if (i == 2) {
					throw new InterruptedException();
				}
				
//				Another way to do it.  It looks like you'd use this when the thread 
//				was interrupted from by a method called by the thread.
				if (Thread.interrupted()) {
					throw new InterruptedException();
				}
				
				
			} catch (InterruptedException e) {
		        // We've been interrupted: no more messages.
		        System.err.println("We've been inturrupted.");
				return;
		    }
			// Print a message
			System.out.println(importantInfo[i]);
		}
	}
}