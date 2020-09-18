package com.test.hello;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution48 {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] arr) {
        int len = arr.length;
        List<Long> areas = new ArrayList<>();
        for (int j = 2; j < len + 1; j++) {
            for (int i = 0; i < len - 1; i++) {
                //int temp[] = Arrays.copyOfRange(arr, i, j + i);
                //calcSubArr(temp, j, areas);
                int min = getMin(arr, i, j + i);
                long elem = (long) (min) * ((long) j);
                areas.add(elem);
            }
        }
        Collections.sort(areas);
        return areas.get(areas.size() - 1);
    }

    static int getMin(int[] subArr, int beg, int end) {
        int min = 900000000;
        end  = (end> subArr.length ? subArr.length : end);
        for (int i = beg; i < end; i++) {
            if (min > subArr[i])
                min = subArr[i];
        }
        return min;
    }

    static void calcSubArr(int[] subArr, int num, List<Long> areas) {
        Arrays.sort(subArr);
        long elem = (long) (subArr[0]) * ((long) num);
        areas.add(elem);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

