package com.test.hello;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution30 {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> listResult = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        for (List<Integer> list1 : queries) {
            int oper = list1.get(0);
            int val = list1.get(1);

            Integer occur = map.get(val);
            if (oper == 1) {
                if (occur != null && occur > 0) {
                    map.put(val, ++occur);
                } else {
                    map.put(val, 1);
                }
            } else if (oper == 2) {
                if (occur != null && occur > 0) {
                    map.put(val, --occur);
                } else {
                    map.put(val, 0);
                }
            } else if (oper == 3) {
                boolean res = map.containsValue(val);
                int chk = res ? 1 : 0;
                System.out.println(chk);
                listResult.add(chk);
            }
        }

        return listResult;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
