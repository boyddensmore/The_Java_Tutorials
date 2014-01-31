package com.densmore.exceptions;

//Note: This class won't compile by design!
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {

 private List<Integer> list;
 private static final int SIZE = 10;

 public ListOfNumbers () {
     list = new ArrayList<Integer>(SIZE);
     for (int i = 0; i < SIZE; i++) {
         list.add(new Integer(i));
     }
 }
 
 public void writeList() {
	 PrintWriter out = null; 
			 
	 try {
		 System.out.println("Entered Try statement");
		 out = new PrintWriter(new FileWriter("OutFile.txt"));
		 for (int i = 0; i < SIZE; i++) {
	         out.println("Value at: " + i + " = " + list.get(i));
	     }
	 } catch (FileNotFoundException e) {
		 System.err.println("FineNotFoundException: " + e.getMessage());
		 throw new SampleException(e);
	 } catch (IOException e) {
		 System.err.println("Caught IOException: " + e.getMessage());
	 }
     
     out.close();
 }
}