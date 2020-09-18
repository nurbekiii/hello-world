package com.test.hello;

/**
 * @author NIsaev on 16.03.2020
 */

import java.util.Scanner;

class Interval {
    int i;
    int j;
}

public class IncrementArray {
    public static void main(String[] args) {
        int k = 5;                                   // increase array elements by this value
        Scanner sc = new Scanner(System.in);
        int intervalNo = sc.nextInt();                // specify no of intervals
        Interval[] interval = new Interval[intervalNo];           // array containing ranges/intervals
        System.out.println(">" + sc.nextLine() + "<");
        for (int i = 0; i < intervalNo; i++) {
            interval[i] = new Interval();
            String s = sc.nextLine();                             // specify i and j separated by comma in one line for an interval.
            String[] s1 = s.split(" ");
            interval[i].i = Integer.parseInt(s1[0]);
            interval[i].j = Integer.parseInt(s1[1]);
        }
        int[] arr = new int[10];           // array whose values need to be incremented.
        for (int i = 0; i < arr.length; ++i)
            arr[i] = i + 1;                    // initialising array.
        int[] temp = new int[10];
        Interval run = interval[0];
        int i;
        for (i = 0; i < intervalNo; i++, run = interval[i < intervalNo ? i : 0])  // i<intervalNo?i:0 is used just to avoid arrayBound Exceptions at last iteration.
        {
            temp[run.i] += k;
            if (run.j + 1 < 10)                                          // incrementing temp within array bounds.
                temp[run.j + 1] -= k;
        }
        for (i = 1; i < 10; ++i)
            temp[i] += temp[i - 1];

        for (i = 0, run = interval[i]; i < 10; i++) {
            arr[i] += temp[i];
            System.out.print(" " + arr[i]);                     // printing results.
        }


    }
}
