package com.densmore.exceptionhandling;

import java.io.IOException;

public class TestClasses {

	public void main(String[] args) {

		String path = "c:/tmuninst.inii";

		ListOfNumbers numList = new ListOfNumbers();

		try {
			String result = numList.readFirstLineFromFile(path);
			System.out.println(result);
		} catch (IOException e) {
			System.err.println("Error handled!");
			System.err.println(e.getLocalizedMessage());
		}
		
	}

}
