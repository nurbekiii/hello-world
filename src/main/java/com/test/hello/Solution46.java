package com.test.hello;

/**
 * @author NIsaev on 01.05.2020
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution46 {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        int[] arr22 = Arrays.stream(arr).sorted().toArray();
        int minest = arr22[arr22.length - 1];

        for (int i = 0; i < arr22.length - k + 1; i++) {
            int diff = arr22[i + k - 1] - arr22[i];
            if (diff <= minest)
                minest = diff;
        }

        return minest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

