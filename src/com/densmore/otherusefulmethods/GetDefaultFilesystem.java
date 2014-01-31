package com.densmore.otherusefulmethods;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

public class GetDefaultFilesystem {


	public static void main(String[] args) {

		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.*");
		
		System.out.println(matcher.toString());
		
	}

}
