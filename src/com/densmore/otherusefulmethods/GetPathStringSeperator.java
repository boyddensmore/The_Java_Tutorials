package com.densmore.otherusefulmethods;

import java.io.File;
import java.nio.file.FileSystems;

public class GetPathStringSeperator {

	public static void main(String[] args) {

//		Either of these should work.  
//		Not sure what the difference is, aside from being in different packages.
		
		String separator = File.separator;
		System.out.println(separator);
		
		separator = FileSystems.getDefault().getSeparator();
		System.out.println(separator);
		
	}

}
