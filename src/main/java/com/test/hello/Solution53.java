package com.test.hello;

/**
 * @author NIsaev on 12.05.2020
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution53 {

    // Complete the flippingBits function below.
    static long flippingBits(long n) {
        String binaryString = Long.toBinaryString(n);
        int len = binaryString.length();
        if (len < 32)
            binaryString = "0000000000000000000000000000000000000000" .substring(0, 32 - len) + binaryString;

        char[] arr = binaryString.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (arr[i] == 48 ? 49 : 48);
        }
        String res2 = new String(arr);
        long res3 = new BigInteger(res2, 2).longValue();
        return res3;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);
            System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
