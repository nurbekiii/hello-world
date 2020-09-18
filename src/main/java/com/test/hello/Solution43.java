package com.test.hello;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution43 {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        try {
            SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
            Date date = parseFormat.parse(s);
            return displayFormat.format(date);
        }catch (Exception t){
            t.printStackTrace();
        }
        return null;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println(result);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

