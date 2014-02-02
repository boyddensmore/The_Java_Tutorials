package com.densmore.fileio;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ThePathsClass {
	
	public void main(String[] args) {

		Path p1 = Paths.get("/tmp/foo");

//		This one errors, as we're not receiving any args yet.
//		Path p2 = Paths.get(args[0]);
		
		Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));
		
//		Paths.get is shorthand for the following.  See how easy?  :)
		Path p4 = FileSystems.getDefault().getPath("/users/sally");
		
//		Handy dandy, don't forget to check out System.getProperty.  
//		Looks like there could be some interesting content. 
		Path p5 = Paths.get(System.getProperty("user.home"),"logs", "foo.log");
		
		
//		Getting all sorts of useful information about a path
		
		Path path = Paths.get(System.getProperty("user.home"), "foo.txt");
		
		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getParent: %s%n", path.getParent().getParent());
		System.out.format("getParent: %s%n", path.getParent().getParent().getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
		
//		Here we're taking a path and making it absolute.
//		At the same time, we're confirming whether or not this file/directory exists.
//		In Unix systems, this should also follow symlinks, making sure that the path is fully resolved.
		
		try {
		    Path fp = path.toRealPath();
		    System.out.println(fp);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path);
		    // Logic for case when file doesn't exist.
		} catch (IOException x) {
		    System.err.format("%s%n", x);
		    // Logic for other sort of file error.
		}
		
		System.out.println();
		
//		
		
		path = Paths.get(System.getProperty("user.home"), ".VirtualBox");
		
		System.out.format("%s%n", path.resolve("bar"));
		System.out.println(path.equals(path));
		System.out.println(path.equals(p3));
		System.out.println();
		System.out.println(path.endsWith("bdensmor"));
		System.out.println(path.startsWith("C:\\Documents and Settings\\"));
		System.out.println(path.startsWith("C:\\Documents and Settings"));
		System.out.println(path.startsWith("C:\\Documents and"));
		
		System.out.println();
		
//		Now let's print out each element of the path, ignoring the root.
		for (Path name: path) {
		    System.out.println(name);
		}
		
		
		
	}

}
