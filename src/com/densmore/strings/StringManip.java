package com.densmore.strings;

public class StringManip {
	
//	For some details, check out...
//	http://www.trijug.org/downloads/Power%20Regular%20Expressions%20using%20Java.pdf

	
	public static void splitStrings(String toBeSplit){

		String[] splitString = toBeSplit.split("\\.");
		
		for (int i=0; i < splitString.length; i++){
			System.out.println(splitString[i]);
		}
		
	}
	
	public static void findIndexes(String toBeSearched){

		System.out.println("Index of '3': " + toBeSearched.indexOf("3"));
		System.out.println("Index of '.3': " + toBeSearched.indexOf(".3"));
		System.out.println("Index of second '.': " + toBeSearched.indexOf(".", 2));
		
		System.out.println(toBeSearched.contains("4"));
		System.out.println(toBeSearched.contains("5"));
		
		System.out.println("Index of last '.': " + toBeSearched.lastIndexOf("."));
		
	}
	
	public static void main(String[] args) {
		String toManip = "1.2.3.4";
		
		
		splitStrings(toManip);
		System.out.println();
		
		findIndexes(toManip);
		System.out.println();

	}

}
