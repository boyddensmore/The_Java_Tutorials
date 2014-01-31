package com.densmore.basicconcurrency;

public class Synchronized {

	/**
	 * This class makes use of the synchronized keyword to make sure that
	 * no more than one invocation of the class can use an object.  This will
	 * prevent interleave between threads.
	 *
	 * Also, the synchronized keyword ensures that when a method exits, it establishes
	 * a happens-before relationship with any subsequent invocation of a synchronized 
	 * method for the same object.  This ensures that changes to the state of the object
	 * are visible to all threads.
	 */
	public class SyncCounter {
		private int c;

		public synchronized void increment() {
			c++;
		}

		public synchronized void decrement() {
			c--;
		}

		public synchronized int value() {
			return c;
		}

//		Constructors can't use the synchronized keyword.
//		It wouldn't make sense, as the only thread that should have access to it while 
//		it's being constructed is the one calling it. 
		
//		When constructing something like this, be sure not to "leak" any reference to the new
//		object before the construction is complete.
//		For example, don't have something in the constructor like:
//			instances.add(this);
//		
//		Where instances is a list field that's part of the class.  Make sure to add the objects 
//		to the list from outside the constructor:
//			Blah blah = new SyncCounter();
//			List list.add(blah);
		
		public SyncCounter() {
			c = 0;
		}
		


	}

	public void main(String args[]) {

	}

}
