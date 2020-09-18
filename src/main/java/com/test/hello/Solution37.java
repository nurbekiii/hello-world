package com.test.hello;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution37 {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long[] distinctOrdered = Arrays.stream(machines).sorted().distinct().toArray();
        Map<Long, Long> map = new TreeMap<>();
        for (long elem : distinctOrdered) {
            long num = countOccurences(machines, elem);
            map.put(elem, num);
        }

        boolean isDublicated = (machines.length > distinctOrdered.length + 30);
        long days = machines[0];
        long sm = 0;
        while (sm <= goal) {
            if (isDublicated) {
                for (Map.Entry<Long, Long> entry : map.entrySet()) {
                    long machine = entry.getKey();
                    long num = entry.getValue();
                    if (days % machine == 0) {
                        sm = sm + num;
                    }
                }
            } else {
                for (long machine : machines) {
                    if (days % machine == 0)
                        sm++;
                }
            }
            if (sm >= goal)
                break;
            days++;
        }
        return days;
    }

    static long countOccurences(long[] machines, long check) {
        long num = 0;
        for (long elem : machines) {
            if (elem > check)
                break;
            else if (elem == check)
                num++;
        }
        return num;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);
        System.out.println(ans);
        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
