package com.densmore.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadingWritingCreatingFiles {

	// Level 0 - Utilities
	public static boolean deleteFile(Path path) {
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

	// Level 1 - Simple byte reader
	public static byte[] byteReader(Path path) {
		byte[] fileArray;

		try {
			fileArray = Files.readAllBytes(path);
			return fileArray;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Level 1 - Simple byte writer
	public static void byteWriter(byte[] toWrite, Path path) {
		try {
			Files.write(path, toWrite);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Level 2 - Buffered Stream reader
	public static ArrayList<String> bufferedStreamReader(Path path) {
		Charset charset = Charset.forName("US-ASCII");
		ArrayList<String> fileContents = new ArrayList<String>();

		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
			String line = null;

			while ((line = reader.readLine()) != null) {
				fileContents.add(line);
			}
			return fileContents;
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
			return null;
		}
	}

	// Level 2 - Buffered Stream writer
	public static int bufferedStreamWriter(ArrayList<String> toWrite, Path path) {
		Charset charset = Charset.forName("US-ASCII");

		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			for (int i = 0; i < toWrite.size(); i++) {
				writer.write(toWrite.get(i));
				writer.newLine();
			}
			return 0;
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
			return -1;
		}
	}

	// Level 3 - Read SeekableByteChannel
	public static void readSeekableByteChannel(Path path) {
		try (SeekableByteChannel sbc = Files.newByteChannel(path)) {
			ByteBuffer buf = ByteBuffer.allocate(5);
			// Read the bytes with the proper encoding for this platform. If
			// you skip this step, you might see something that looks like
			// Chinese characters when you expect Latin-style characters.
			String encoding = System.getProperty("file.encoding");
			while (sbc.read(buf) > 0) {
				buf.rewind();
				System.out.print(Charset.forName(encoding).decode(buf));
				buf.flip();
				// TODO - readSeekableByteChannel - Figure out why the last buffer prints strangely
				// Down to a sunless sea.nless se
				// instead of
				// Down to a sunless sea.
			}
			// TODO - readSeekableByteChannel - return something instead of writing to Out.
		} catch (IOException e) {
			System.out.println("caught exception: " + e);
		}
	}

	// Level 3 - Write SeekableByteChannel
	// TODO 2 - build writeSeekableByteChannel - this is a copy from the tutorial
	// for a POSIX system.
	// public static void writeSeekableByteChannel(Path path, ArrayList<String>
	// toWrite){
	//
	// // Create the set of options for appending to the file.
	// Set<OpenOption> options = new HashSet<OpenOption>();
	// options.add(APPEND);
	// options.add(CREATE);
	//
	// // Create the custom permissions attribute.
	// Set<PosixFilePermission> perms =
	// PosixFilePermissions.fromString("rw-r------");
	// FileAttribute<Set<PosixFilePermission>> attr =
	// PosixFilePermissions.asFileAttribute(perms);
	//
	// // Convert the string to a ByteBuffer.
	// String s = ...;
	// byte data[] = s.getBytes();
	// ByteBuffer bb = ByteBuffer.wrap(data);
	//
	// try (SeekableByteChannel sbc = Files.newByteChannel(file, options, attr))
	// {
	// sbc.write(bb);
	// } catch (IOException x) {
	// System.out.println("exception thrown: " + x);
	// }
	//
	// }

	public static void main(String[] args) {

		Path readPath = Paths.get(System.getProperty("user.home")
				+ "\\xanadu.txt");
		Path byteWritePath = Paths.get(System.getProperty("user.home")
				+ "\\out-byte-xanadu.txt");
		Path buffWritePath = Paths.get(System.getProperty("user.home")
				+ "\\out-buff-stream-xanadu.txt");

		byte[] readFromFile = null;
		ArrayList<String> listReadFromFile = null;

		// Level 1 - Simple byte reader
		readFromFile = byteReader(readPath);

		// Level 1 - Simple byte writer
		if (readFromFile != null) {
			byteWriter(readFromFile, byteWritePath);
		}

		deleteFile(byteWritePath);

		// Level 2 - Buffered Stream reader
		listReadFromFile = bufferedStreamReader(readPath);
		// System.out.println(listReadFromFile.size());

		// Level 2 - Buffered Stream writer
		bufferedStreamWriter(listReadFromFile, buffWritePath);

		deleteFile(buffWritePath);

		// Level 3 - Read SeekableByteChannel
		readSeekableByteChannel(readPath);

		// Level 3 - Write SeekableByteChannel
		// TODO - Use writeSeekableByteChannel

		// Create a file

		try {
			// Create the empty file with default permissions, etc.
			Files.createFile(buffWritePath);
		} catch (FileAlreadyExistsException x) {
			System.err.format("file named %s" + " already exists%n",
					buffWritePath);
		} catch (IOException x) {
			// Some other sort of failure, such as permissions.
			System.err.format("createFile error: %s%n", x);
		}

		deleteFile(buffWritePath);

		// Create a temp file
		try {
			Path tempFile = Files.createTempFile(null, ".myapp");
//			Write out to the new temp file
			listReadFromFile = bufferedStreamReader(readPath);
			bufferedStreamWriter(listReadFromFile, tempFile);			
			System.out.format("%nThe temporary file" + " has been created: %s%n",
					tempFile);
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

}
