package com.test.hello;

import java.util.Scanner;

public class Solution39 {

    // Complete the staircase function below.
    static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j <= i; j++) {
               s += "#";
            }

            String ss =  String.format("%"+n+"s", s);
            System.out.println(ss);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}

