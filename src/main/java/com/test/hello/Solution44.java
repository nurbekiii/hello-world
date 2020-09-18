package com.test.hello;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution44 {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {
        int num = arr.length;
        if(num ==1)
            return new int[]{arr[0], arr[0]};

        int arr2[] = new int[num];
        int t = 0;
        for (int elem : arr) {
            arr2[t] = elem;
            t++;
        }
        Arrays.sort(arr2);
        int last = arr2[num - 1];
        if (last <= 0)
            return new int[]{last, last};
        /////
        int sm1 = 0;
        int sm2 = 0;
        int i = 0;
        for (int elem : arr) {
            if (sm2 + elem > sm2) {
                sm2 = sm2 + elem;
            } else {
                sm1 = sm1+elem;
            }
            i++;
        }
        return new int[]{sm1, sm2};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            System.out.println("" + result[0] + " " + result[1]);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
