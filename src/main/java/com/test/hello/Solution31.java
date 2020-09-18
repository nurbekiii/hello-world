package com.test.hello;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution31 {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        Long[] arr2 = new Long[arr.size()];
        arr.toArray(arr2);

        long num = 0;
        for (int i = 0; i < arr2.length; i++) {
            long first = arr2[i];
            for (int j = i + 1; j < arr2.length - 1; j++) {
                long second = arr2[j];
                if (first * r != second)
                    continue;

                for (int k = j + 1; k < arr2.length; k++) {
                    long third = arr2[k];

                    if (first * r == second && second * r == third)
                        num++;
                }
            }
        }
        return num;
    }

    static String twoStrings(String s1, String s2) {
        String check = (s1.length() > s2.length() ? s2 : s1);
        boolean isS1 = s1.equals(check);
        if(check.length() > 1000)
            check = check.substring(0, 1000);

        for (int i = 0; i < check.length(); i++) {
            String s = check.substring(i, i + 1);
            boolean hasSustring = (isS1 ? s2.contains(s) : s1.contains(s));
            if (hasSustring)
                return "YES";
        }
        return "NO";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);
        System.out.println(ans);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
