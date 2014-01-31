package com.densmore.otherusefulmethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeterminingMimeTypes {

	public static void printMimeType(Path filename) {

		try {
			String type = Files.probeContentType(filename);
			if (type == null) {
				System.err.format("'%s' has an" + " unknown filetype.%n",
						filename);
			} else if (!type.equals("text/plain")) {
				System.err.format("'%s' (%s) is" + " a plain text file.%n", filename, type);
			} else if (type.equals("text/plain")) {
				System.out.format("'%s' (%s) is" + " a plain text file.%n", filename, type);
			}
		} catch (IOException x) {
			System.err.println(x);
		}

	}

	public static void main(String[] args) {

		Path fileOne = Paths.get(System.getProperty("user.home")
				+ "\\xanadu.txt");
		Path fileTwo = Paths.get(System.getProperty("user.home")
				+ "\\NTUSER.DAT.LOG");
		Path fileThree = Paths.get(System.getProperty("user.home")
				+ "\\gsview32.ini");

		printMimeType(fileOne);
		printMimeType(fileTwo);
		printMimeType(fileThree);

	}

}
