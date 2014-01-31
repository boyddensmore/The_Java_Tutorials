package com.densmore.basicio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreams {
	static final String dataFile = "invoicedata";

	
//	Caution, if you're trying to read in currency, don't use this.
//	Doubles and floats aren't precise enough.  You should use java.math.BigDecimal through Object Streams.
	static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = { "Java T-shirt", "Java Mug",
			"Duke Juggling Dolls", "Java Pin", "Java Key Chain" };

	public static void main(String[] args) throws IOException {

		DataOutputStream out = null;

//		Write the values out to a file.
		
		try {
//			Like other complex streams, the Data Output Stream needs to wrap a buffered Character stream.
//			Buffered character streams need to wrap byte streams.
			out = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(dataFile)));

			
//			Might be a good idea to make sure that all of the variables have the same number of elements...
			for (int i = 0; i < prices.length; i++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}
		} finally {
			out.close();
		}

		
		
//		Read the file back in.
		
		DataInputStream in = null;
		double total = 0.0;
		try {
//			Create a data stream.  A Data Stream needs a buffered input stream, which needs a file input stream.
//			File input streams are Byte streams.
			
			in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(dataFile)));

			double price;
			int unit;
			String desc;

			try {
				while (true) {
//					Read each value in turn, using the provided methods for each data type.
					price = in.readDouble();
					unit = in.readInt();
					desc = in.readUTF();
					System.out.format("You ordered %d units of %s at $%.2f%n",
							unit, desc, price);
					total += unit * price;
				}
//			All implementations of DataStreams use EOFException instead of return values.
			} catch (EOFException e) {
			}
			System.out.format("For a TOTAL of: $%.2f%n", total);
		} finally {
			in.close();
		}
	}
}