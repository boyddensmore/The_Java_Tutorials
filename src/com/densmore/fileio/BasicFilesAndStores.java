package com.densmore.fileio;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicFilesAndStores {

	private Path path = null;
	private Path newPath = null;
	private Path newMovePath = null;

	// Make sure the file exists.
	public static boolean verifyPath(Path pathToCheck) {
		return pathToCheck.toFile().exists();
	}

	// Make sure access is possible. Reading and writing, as well as making sure
	// this is a regular file.
	public boolean verifyFullFileAccess(Path pathToCheck) {
		return Files.isRegularFile(pathToCheck) & Files.isReadable(pathToCheck)
				& Files.isWritable(pathToCheck);
	}

	public boolean deleteFile(Path path) {
		try {
			Files.delete(path);
			return true;
		} catch (NoSuchFileException e) {
			System.err.format("%s: no such" + " file or directory%n", path);
			return false;
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", path);
		    return false;
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		    return false;
		}
	}
	
	
	public void main(String[] args) {

		path = Paths.get(System.getProperty("user.home") + "\\foo.txt");
		newPath = Paths.get(System.getProperty("user.home") + "\\fooNew.txt");
		newMovePath = Paths.get(System.getProperty("user.home")
				+ "\\fooNewAfterMove.txt");

		System.out.println(path.toString() + " exists?: " + verifyPath(path));
		System.out.println("You have access to " + path.getFileName() + "?: "
				+ verifyFullFileAccess(path));

//		Copy file
		try {
			Files.copy(path, newPath, REPLACE_EXISTING);
			System.out.println("File copied.");
		} catch (IOException e) {
			System.out
					.format("Could not copy file.  Please ensure that the following file doesn't already exist. %n %s",
							newPath.toString());
		}

//		Move copied file
		try {
			Files.move(newPath, newMovePath, REPLACE_EXISTING);
			System.out.println("Copied file moved.");
		} catch (IOException e) {
			System.out
					.format("Could not move file.  Please ensure that the following file doesn't already exist. %n %s",
							newMovePath.toString());
		}

//		Delete moved file
		deleteFile(newMovePath);
		
//		Print details of the file referenced by path. 
		try {
			System.out.format("%n%-15s %-10s %n", "Details for", path.getFileName());
			System.out.format("%-15s %d%n", "Size:",  Files.size(path));
			System.out.format("%-15s %s%n", "Directory?", Files.isDirectory(path));
			
			System.out.format("%-15s %s%n", "Directory?", Files.isDirectory(path));
			System.out.format("%-15s %s%n", "Regular file?", Files.isRegularFile(path));
			System.out.format("%-15s %s%n", "Symbolic link?", Files.isSymbolicLink(path));
			System.out.format("%-15s %s%n", "Last modified:", Files.getLastModifiedTime(path));
			System.out.format("%-15s %s%n", "Owner", Files.getOwner(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();

//		Or, possibly nicer...
		try {
			BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

			System.out.println("creationTime:     	" + attr.creationTime());
			System.out.println("lastAccessTime:   	" + attr.lastAccessTime());
			System.out.println("lastModifiedTime: 	" + attr.lastModifiedTime());
			System.out.println("isDirectory: 		" + attr.isDirectory());
			System.out.println("isOther: 		" + attr.isOther());
			System.out.println("isRegularFile: 		" + attr.isRegularFile());
			System.out.println("isSymbolicLink: 	" + attr.isSymbolicLink());
			System.out.println("size: 			" + attr.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.format("%n%s%n%n", "Store usage for c:\\");
		
		try {
			FileStore store = Files.getFileStore(path);

//			int kbConversion = 1024;
//			int mbConversion = 1048576;
			int gbConversion = 1073741824;
			
			System.out.format("Total :		%,d GB%n", store.getTotalSpace() / gbConversion);
			System.out.format("Used  :		%,d GB%n", (store.getTotalSpace() -
			             store.getUnallocatedSpace()) / gbConversion);
			System.out.format("Avail :		%,d GB%n", store.getUsableSpace() / gbConversion);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
