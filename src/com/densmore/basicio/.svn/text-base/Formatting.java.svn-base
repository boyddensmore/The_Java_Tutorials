package com.densmore.basicio;

import java.util.Calendar;
import java.util.Locale;

public class Formatting {

	public static void main(String[] args) {
		int i = 2;
		double r = Math.sqrt(i);

		// - d formats an integer value as a decimal value.
		// - f formats a floating point value as a decimal value.
		// - n outputs a platform-specific line terminator.
		System.out.format("The square root of %d is %f.%n", i, r);

		// Here are some other conversions, but there are many more:
		//
		// - x formats an integer as a hexadecimal value.
		// - s formats any value as a string.
		// - tB formats an integer as a locale-specific month name.

		// Also, you can format numbers to include leading 0s, total number of
		// digits, etc.

		System.out.format("%f, %1$+05.10f %n", Math.PI);
		System.out.format("%f, %1$+010.10f %n", Math.PI);
		System.out.format("%f, %1$+015.10f %n", Math.PI);
		System.out.format("%f, %1$+020.10f %n", Math.PI);
		System.out.format("%f, %1$+020.5f %n", Math.PI);
		System.out.format("%f, %1$,025.10f %n", Math.PI);
		System.out.format("%f, %1$025.10f %n", Math.PI);

		long n = 461012;
		System.out.format("%d%n", n); // --> "461012"
		System.out.format("%08d%n", n); // --> "00461012"
		System.out.format("%+8d%n", n); // --> " +461012"
		System.out.format("%,8d%n", n); // --> " 461,012"
		System.out.format("%+,8d%n%n", n); // --> "+461,012"

		double pi = Math.PI;

		System.out.format("%f%n", pi); // --> "3.141593"
		System.out.format("%.3f%n", pi); // --> "3.142"
		System.out.format("%10.3f%n", pi); // --> "     3.142"
		System.out.format("%-10.3f%n", pi); // --> "3.142"
		System.out.format(Locale.FRANCE, "%-10.4f%n%n", pi); // --> "3,1416"

		Calendar c = Calendar.getInstance();
		System.out.format("%tB %te, %tY%n", c, c, c); // --> "May 29, 2006"

		System.out.format("%tl:%tM %tp%n", c, c, c); // --> "2:34 am"

		System.out.format("%tD%n", c); // --> "05/29/06"

	}

}
