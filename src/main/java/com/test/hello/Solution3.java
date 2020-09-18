package com.test.hello;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * @author NIsaev on 26.02.2020
 */
public class Solution3 {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();

            map.put(name, phone);
        }
        StringBuffer buf = new StringBuffer();
        while (in.hasNext()) {
            String s = in.nextLine();
            Integer phone = map.get(s);
            buf.append((phone != null ? (s + "=" + phone) : "Not found") + "\n");
        }

        System.out.println(buf.toString());
    }
}
