package com.test.hello;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution6 {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }


        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sm = getArrSum(i, j, arr);
                set.add(sm);
                //System.out.println("hello1");
            }
            //System.out.println("");
        }

        int max = -500000;
        for (int el : set) {
            System.out.println(el);

            if (max < el)
                max = el;
        }

        System.out.println(max);

        scanner.close();
    }

    private static int getArrSum(int row, int col, int[][] arr) {
        int sm = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && (j == 0 || j == 2))
                    continue;

                sm += arr[row + i][col + j];
            }
        }
        //System.out.print("("+row+","+col + ")=" + sm + "  ");
        return sm;
    }


    private static int[][] getArr(int row, int col, int[][] arr) {
        int temp[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = arr[row + i][col + j];
            }
        }
        return temp;
    }

}