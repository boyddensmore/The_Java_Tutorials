package com.densmore.otherusefulmethods;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFileStores {

	public static void main(String[] args) {
		
//		Where are my files?
//		I guess now I know.
		
//		Get all of the file stores for the system.
		System.out.println("Get all filestores used by the system.");
		
		for (FileStore store: FileSystems.getDefault().getFileStores()) {
			   System.out.println(store.name());
			}

		
//		Get the filestore used for a single file.
		Path file = Paths.get(System.getProperty("user.home") + "\\xanadu.txt");
		
		System.out.format("Get the filestore for a single file (%s)%n", file.getFileName());
		
		try {
			FileStore store = Files.getFileStore(file);
			System.out.println(store.name());
		} catch (IOException e) {
			System.err.println("IO Exception: " + e);
		}
		
	}

}
