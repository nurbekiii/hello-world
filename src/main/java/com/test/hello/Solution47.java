package com.test.hello;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution47 {

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        int len = s.length();
        String s1 = s.substring(0, len/2);
        String s2 = s.substring(len/2);

       if(s1.length() == s2.length()){
           if(s1.compareTo(s2) <=0)
               return s1;

           return s2;
       }

        return s1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

