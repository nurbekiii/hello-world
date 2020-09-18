package com.test.hello;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Scanner;
import java.io.IOException;
import java.lang.reflect.Method;


class Printer
{
    //Write your code here
    public void printArray(Object [] arr){

        for(Object obj : arr){
            System.out.println(obj);
        }
    }

}

public class Solution {


    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");

    }

    public static void mainLocaleMoney(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "in")).format(payment);

        // Write your code here.

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }


    public static String findDay(int month, int day, int year) {

        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US).toUpperCase();
    }

    public static void mainDayOfWeek(String[] args) throws IOException {

        System.out.println(findDay(8, 5, 2015));
        System.out.println(findDay(2, 26, 2020));
        System.out.println(findDay(2, 27, 2020));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Solution.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }


    public static void mainFormatting(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Complete this line
            String num=String.format("%03d", x);
            buf.append(String.format("%s%15.15s\n", s1, num));
        }
        System.out.println(buf.toString());
        System.out.println("================================");

    }


    public static void mainReadDiffTypes(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();
        double d = scan.nextDouble();
        String s = "";
        while (scan.hasNextLine()) {
            s = scan.nextLine();
            if (s.length() > 0)
                break;
        }
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

    }

    public void main22(String[] args) {
        Scanner scanner2 = new Scanner(System.in);


        while (true) {
            int N = scanner2.nextInt();
            scanner2.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            if (!(N >= 1 && N <= 100)) {
                scanner2.close();
                return;
            }

            if (N % 2 == 1)
                System.out.println("Weird");
            else {
                if (N >= 2 && N <= 5)
                    System.out.println("Not Weird");
                else if (N >= 6 && N <= 20)
                    System.out.println("Weird");
                else if (N > 20)
                    System.out.println("Not Weird");
            }

            if (false)
                scanner2.close();
        }
    }
}
