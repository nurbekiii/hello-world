package com.test.hello;

/**
 * @author NIsaev on 12.05.2020
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution52 {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        Set<Character> set1 = convertToSet(s1.toCharArray());
        Set<Character> set2 = convertToSet(s2.toCharArray());
        boolean isLonger1 = set1.size() > set2.size();
        boolean exists;
        int num = 0;
        for (char ch : (isLonger1 ? set2 : set1)) {
            if (isLonger1) {
                exists = hasChar(set1, ch);
                if (exists)
                    num++;
            } else {
                exists = hasChar(set2, ch);
                if (exists)
                    num++;
            }
        }
        return num;
    }

    static boolean hasChar(Set<Character> set, char check) {
        for (char chCur : set) {
            if (chCur == check)
                return true;
        }
        return false;
    }

    static Set<Character> convertToSet(char[] charArray) {
        Set<Character> resultSet = new TreeSet<>();
        for (int i = 0; i < charArray.length; i++) {
            resultSet.add(new Character(charArray[i]));
        }
        return resultSet;
    }


    static boolean hasChar(char[] arr2, char check) {
        for (char chCur : arr2) {
            if (chCur == check)
                return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
