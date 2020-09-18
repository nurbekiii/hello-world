package com.test.hello;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution20 {
  // Complete the arrayManipulation function below.
  static long arrayManipulation111(int n, int[][] queries) {
      int []arr = new int[n + 1];

      // Start performing 'm' operations
      for (int i = 0; i < queries.length; i++)
      {
          // Store lower and upper
          // index i.e. range
          int beg = queries[i][0] - 1;
          int end = queries[i][1] - 1;
          int add = queries[i][2];

          // Add k to the lower_bound
          arr[beg] += add;

          // Reduce upper_bound+1
          // indexed value by k
          arr[end + 1] -= add;
      }

      // Find maximum sum
      // possible from all values
      long sum = 0, res = Integer.MIN_VALUE;
      for (int i = 0; i < n; ++i)
      {
          sum += arr[i];
          res = Math.max(res, sum);
      }

      // return maximum value
      return res;
  }


  static long arrayManipulation(int n, int[][] queries) {


      long arr[] = new long[n];
      for (int i = 0; i < queries.length; i++) {
          int beg = queries[i][0] - 1;
          int end = queries[i][1] - 1;
          int add = queries[i][2];

          for (int j = beg; j <= end; j++) {
              arr[j] = arr[j] + add;
          }
      }
      Arrays.parallelSort(arr);
      long max = arr[arr.length - 1];

      return max;
  }

    static long arrayManipulationEx(int n, int[][] queries) {
        long arr[] = new long[n];

        for (int i = 0; i < queries.length; i++) {
            int beg = queries[i][0] - 1;
            int end = queries[i][1] - 1;
            int add = queries[i][2];

            for (int j = beg, m = end; j <= end; j++, m--) {
                if (j >= m)
                    break;

                arr[j] = arr[j] + add;
                arr[m] = arr[m] + add;
            }
        }
        Arrays.parallelSort(arr);
        long max = arr[arr.length - 1];

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/22.txt"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation111(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        System.out.println(result);

        scanner.close();
    }
}