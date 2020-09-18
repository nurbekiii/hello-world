package com.test.hello;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution34 {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int num = n;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n-2; j++) {
                String kkk = s.substring(i, j);
                System.out.println(kkk);

                List<String> list = partition(kkk, i+2);
                for (String ss : list) {
                    if (ss.length() == 1)
                        continue;

                    //System.out.println(ss);
                    Integer res = map.get(ss);
                    if (res != null && res > 0) {
                        //System.out.println(ss);
                        num++;
                        continue;
                    }
                    if (isSpecial(ss)) {
                        map.put(ss, 1);
                        //System.out.println(ss);
                        num++;
                    } else {
                        map.put(ss, 0);
                    }
                    //System.out.println(num);
                }
            }
        }
        return num;
    }

    static boolean isSpecial(String sss) {
        if (sss == null || sss.isEmpty())
            return false;

        int len = sss.length();
        if (sss.charAt(0) != sss.charAt(len - 1))
            return false;

        Set<Character> set = sss.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());

        boolean isOdd = (len % 2 == 1);
        if (isOdd) {
            return (set.size() <= 2);
        } else {
            return (set.size() == 1);
        }
    }

    static List<String> partition(String string, int partSize) {
        List<String> parts = IntStream.range(0, string.length() / partSize)
                .mapToObj(i -> string.substring(i * partSize, (i + 1) * partSize))
                .collect(Collectors.toList());
        if ((string.length() % partSize) != 0)
            parts.add(string.substring(string.length() / partSize * partSize));
        return parts;
    }

    static long substrCount55(int n, String s) {
        int num = n;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n + 1; j++) {
                String ss = s.substring(i, j);
                Integer res = map.get(ss);
                if (res != null && res > 0) {
                    num++;
                    continue;
                }
                if (isSpecial(ss)) {
                    map.put(ss, 1);
                    num++;
                } else {
                    map.put(ss, 0);
                }
                //System.out.println(num);
            }
        }
        return num;
    }

    static boolean isSpecial55(String sss) {
        if (sss == null || sss.isEmpty())
            return false;

        int len = sss.length();
        char chc = sss.charAt(0);
        char chLast = sss.charAt(len - 1);
        if (chc != chLast)
            return false;

        boolean isOdd = (len % 2 == 1);
        int mid = len / 2;
        int j = len - 1;
        for (int i = 1; i < sss.length(); i++, j--) {
            if (isOdd && i == mid)
                continue;

            if (sss.charAt(i) != chc)
                return false;

            if (len > 10) {
                if (i > j)
                    break;

                if (sss.charAt(i) != chc || sss.charAt(j) != chc)
                    return false;
            }
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();
        isSpecial("ppppppppppppppppppTsppppppppppppppppp");
        long result = substrCount(n, s);

        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
