package com.test.hello;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution33 {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {

        for(int i = 0; i<cost.length-1; i++){
            int sm1 = cost[i];
            int sm2 = cost[i+1];
            if(sm1 + sm2 == money){
                System.out.println((i+1) + " " +(i+2));
                return;
            }

            for(int j = i+1; j<cost.length; j++){
                sm2 = cost[j];
                if(sm1 + sm2 == money){
                    System.out.println((i+1) + " " +(j+1));
                    return;
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
