package com.test.hello;

import java.util.Arrays;
import java.util.Scanner;

public class Solution41 {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long sm1 = 0, sm2 = 0;
        int pos = 0;
        for (long elem : arr) {
            if (pos != arr.length - 1)
                sm1 += elem;

            if (pos != 0)
                sm2 += elem;

            pos++;
        }
        System.out.println(""+sm1 + " " + sm2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

