package com.test.hello;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author NIsaev on 27.02.2020
 */
public class Solution7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }

    public static void main55(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        StringBuffer buf = new StringBuffer();
        while (testCases > 0) {
            String pattern = in.nextLine();
            testCases--;

            try {
                Pattern pattern1 = Pattern.compile(pattern);
                if (pattern1.pattern() != null) {
                    buf.append("Valid\n");
                }
            } catch (Exception t) {
                buf.append("Invalid\n");
            }
        }

        System.out.println(buf.toString());
    }

    public static void main77(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if (s == null || s.trim().equals("")) {
            System.out.println(0);
            return;
        }

        String arr[] = s.trim().split("[!,?._'@ ]+");
        System.out.println(arr.length);
        for (String ss : arr) {
            System.out.println(ss);
        }

        scan.close();
    }
}

class MyRegex {
    public String pattern =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}
