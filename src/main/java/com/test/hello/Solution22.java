package com.test.hello;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution22 {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int arrFin[][] = {
                        new int[]{arr[i][j], arr[i][j + 1], arr[i][j + 2]},
                        new int[]{arr[i + 1][j], arr[i + 1][j + 1], arr[i + 1][j + 2]},
                        new int[]{arr[i + 2][j], arr[i + 2][j + 1], arr[i + 2][j + 2]}
                };
                int sm = calcSum(arrFin);
                set.add(sm);
                System.out.print(" " + sm);
            }
            System.out.println("");
        }
        int max = Integer.MIN_VALUE;
        for(int elem : set){
            if(max < elem)
                max = elem;
        }
        return max;
    }

    static int calcSum(int[][] arr2) {
        int sm = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if(i ==1 && (j ==0 || j==2))
                    continue;

                sm += arr2[i][j];
            }
        }
        return sm;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/33.txt"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

