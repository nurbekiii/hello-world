package com.test.hello;

import java.util.*;


/**
 * @author NIsaev on 26.02.2020
 */
public class Solution5 {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Set<String> set = new HashSet<>();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            String input = in.nextLine();

            set.add(input);
            int num = set.size();
            buffer.append("" + num+"\n");
        }

        System.out.println(buffer.toString());
    }
}
