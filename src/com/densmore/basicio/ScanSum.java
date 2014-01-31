package com.densmore.basicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class ScanSum {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
        PrintWriter outputStream = null;
        double sum = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            outputStream = new PrintWriter(new FileWriter("OutFile.txt"));
            s.useLocale(Locale.US);

//            Check that there's something in the file.
            while (s.hasNext()) {
//            	See if there are any more doubles and sum them.
            	if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }   
            }
        } finally {
        	outputStream.println(sum);
        	outputStream.close();
            s.close();
        }

    }
}