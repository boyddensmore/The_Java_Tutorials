package com.densmore.fileio;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import sun.org.mozilla.javascript.internal.ObjToIntMap.Iterator;

public class CreatingAndReadingDirectories {

	public static void listFSRootDirs(){
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name: dirs) {
		    System.err.println(name);
		}
	}
	
	public static void listAllDirectoryContents(Path path){
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
			for (Path file: stream) {
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException e) {
			// IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(e);
		}
	}
	
	public static ArrayList<String> filteredDirectoryListing(Path path, String filter) {
		ArrayList<String> results = new ArrayList<String>();
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, filter)) {
			for (Path entry: stream) {
				results.add(entry.getFileName().toString());
			}
			return results;
		} catch (IOException e){
			System.err.println("IO Exception: " + e);
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		Path newPath = Paths.get(System.getProperty("user.home")+ "\\testDir");
		Path multiLevelPath = Paths.get(System.getProperty("user.home")+ "\\testDir\\dir2\\dir3\\dir4");
		Path pathWithContents = Paths.get(System.getProperty("user.home"));
		
		listFSRootDirs();
		
//		Create a new directory as defined by newPath
		try {
			Files.createDirectory(newPath);
			System.out.println("Single directory created.");
		} catch (IOException e){
			System.err.println("IO Exception: " + e);
		}
		
//		Create a new directory as defined by multiLevelPath
		try {
			Files.createDirectories(multiLevelPath);
			System.out.println("Multiple directory levels created.");
		} catch (IOException e){
			System.err.println("IO Exception: " + e);
		}
		
		
//		Try out the listAllDirectoryContents method
		System.out.println("");
		System.out.println("Printing directory contents.");
		listAllDirectoryContents(pathWithContents);

		System.out.println("");
		System.out.println("Printing FILTERED directory contents.");
		
		String directoryFilter = "*.{java,class,jar}";
		directoryFilter = "xanadu*.*";
		directoryFilter = "*.{txt,dat}";
		
//		Print a directory listing filtered with a string
		ArrayList<String> filteredDirList = filteredDirectoryListing(pathWithContents, directoryFilter);
		for (int i=0; i<filteredDirList.size();i++) {
			System.out.println(filteredDirList.get(i));
		}
		
	}
	
}
