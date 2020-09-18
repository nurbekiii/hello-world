package com.test.hello;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Solution26 {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int warns = 0;
        for (int i = 0; i < expenditure.length - d; i++) {
            double median = getMedian(expenditure, d, i, (i+2));
            int nextDayExp = expenditure[i + d];
            if (nextDayExp >= median * 2)
                warns++;
        }

        return warns;
    }

    static double getMedian(int[] expenditure, int d, int fromPos, int mid) {
        int arr[] = Arrays.copyOfRange(expenditure, fromPos, fromPos + d);
        //Arrays.parallelSort(arr);
        mergeSortAndCount(arr, 0, d-1);

        int mid2 = d/2;
        if (d % 2 == 1) {
            return arr[mid2];
        }

        double res = (double) (arr[mid2-1] + arr[mid2]) / 2;
        return res;
    }


    private static long mergeAndCount(int[] arr, int l, int m, int r) {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        long swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        // Fill from the rest of the left subarray
        while (i < left.length)
            arr[k++] = left[i++];

        // Fill from the rest of the right subarray
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

    // Merge sort function
    private static long mergeSortAndCount(int[] arr, int l, int r) {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        long count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/33.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

        long end = System.currentTimeMillis();

        System.out.println("time: " + ((double) (end - start) / 1000));
    }
}

