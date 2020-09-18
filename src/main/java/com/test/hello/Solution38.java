package com.test.hello;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Solution38 {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        Arrays.sort(arr);
        int negs = 0;
        int zeros = 0;
        int pos = 0;
        int num = arr.length;
        for (int i = 0; i < num; i++) {
            if (arr[i] < 0)
                negs++;
            else if (arr[i] == 0)
                zeros++;
            else if (arr[i] > 0)
                pos++;
        }

        DecimalFormat df2 = new DecimalFormat("#.######");

        double fl1 = ((double) pos / (double) num);
        double fl2 = ((double) negs / (double) num);
        double fl3 = ((double) zeros / (double) num);

        System.out.printf("%.6f\n", fl1);
        System.out.printf("%.6f\n", fl2);
        System.out.printf("%.6f\n", fl3);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}

