package com.densmore.basicconcurrency;

public class ProducerConsumerExample {
    public static void main(String[] args) {
    	
//    	Note that Drop is the main worker class here.
//    	Producer and consumer use Drop to store and return
//    	Objects, and it could do a fair bit of processing as well.
    	
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}