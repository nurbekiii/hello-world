package com.test.hello;

/**
 * @author NIsaev on 13.05.2020
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution55 {

    // Complete the maxXor function below.
    static int[] maxXor(int[] arr, int[] queries) {
        // solve here
        List<Integer> list = new ArrayList<>();

        List<Integer> setArr = Arrays.stream(arr).boxed().distinct().collect(Collectors.toList());
        List<Integer> setQuer = Arrays.stream(queries).boxed().distinct().collect(Collectors.toList());;

        for(int quer : setQuer){
            int max = 0;
            for(int elem : setArr){
                int res = (quer ^ elem);

                if(res> max)
                    max = res;
            }
            list.add(max);
        }

        int[] array = list.stream().mapToInt(i -> i).toArray();
        return array;
    }

    static int[] maxXor22(int[] arr, int[] queries) {
        // solve here
        List<Integer> list = new ArrayList<>();
        for(int quer : queries){
            int max = 0;
            for(int elem : arr){
                int res = (quer ^ elem);

                if(res> max)
                    max = res;
            }
            list.add(max);
        }

        int[] array = list.stream().mapToInt(i -> i).toArray();
        return array;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[m];

        for (int i = 0; i < m; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = maxXor(arr, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

