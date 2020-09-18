package com.test.hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    private Tester tester = new Tester();

    public PerformOperation isOdd() {
        tester.operation = 1;
        return tester;
    }

    public PerformOperation isPrime() {
        tester.operation = 2;
        return tester;
    }

    public PerformOperation isPalindrome() {
        tester.operation = 3;
        return tester;
    }
}

class Tester implements PerformOperation {
    public int operation;
    private boolean result = false;

    public boolean check(int a) {
        if (operation == 1) {
            return (a % 2 == 1);
        }
        if (operation == 2) {
            return isPrime(a);
        }
        if (operation == 3) {
            return isPalindrome(a);
        }
        return result;
    }

    public boolean isPrime(int val) {
        if (val >= 1 && val <= 3)
            return true;

        int num = 0;
        for (int i = 1; i <= val; i++) {
            if (val % i == 0)
                num++;
        }
        if (num == 2)
            return true;
        return false;
    }

    public boolean isPalindrome(int val) {
        if (val < 100)
            return false;

        StringBuffer buffer = new StringBuffer();
        buffer.append("" + val);
        String str1 = buffer.toString();
        String str2 = buffer.reverse().toString();
        return (str1.equals(str2));
    }
}


public class Solution13 {

    public static void main(String[] args) throws IOException {
        MyMath myMath = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = myMath.isOdd();
                ret = myMath.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = myMath.isPrime();
                ret = myMath.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = myMath.isPalindrome();
                ret = myMath.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}