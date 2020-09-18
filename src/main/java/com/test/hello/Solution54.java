package com.test.hello;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution54 {

    // Complete the primality function below.
    static String primality(int n) {
        String prime = "Prime";
        String not = "Not prime";

        if (n == 1 || n == 4)
            return not;

        if (n == 2 || n == 3)
            return prime;
        int num = 1;
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                num++;

            if (num > 2)
                return not;

            if (n > 100 && i * 2 > n)
                break;
        }

        return num == 2 ? prime : not;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = primality(n);
            System.out.println(result);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        System.out.println("Finished");
        bufferedWriter.close();

        scanner.close();
    }
}
