package com.densmore.basicconcurrency;

//Don't forget "implements Runnable"
public class SimpleThread implements Runnable {

	// You've got to have an overloaded run method.
	// This is what's run when you call the class' start method.
	public void run() {
		System.out.println("Hello from a thread!");
	}

	// To start the thread, just create a new Thread and pass the object that
	// you want to run.
	// In this case, we're passing a new SimpleThread object.
	public static void main(String args[]) {
		(new Thread(new SimpleThread())).start();
	}
}
