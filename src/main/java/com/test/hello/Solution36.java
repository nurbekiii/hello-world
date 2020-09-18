package com.test.hello;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution36 {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);

        int len = arr.length;
        int num = 0;
        for (int x = 0, y = len - 2; x < len - 1; x++, y--) {
            for (int i = 0, j = len - 1; i < len - 1; i++, j--) {
                if (i + 1 >= j)
                    break;

                if (x>= y)
                    break;

                if (arr[i + 1] - arr[x] == k)
                    num++;

                if (arr[j] - arr[x] == k)
                    num++;

                if (arr[j] - arr[y] == k)
                    num++;
            }
        }

        return num;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
