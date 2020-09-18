package com.test.hello;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author NIsaev on 06.03.2020
 */
public class Solution15 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        String pattern = "\\<(.+)\\>([^\\<\\>]+)\\<\\/\\1\\>";
        Pattern p = Pattern.compile(pattern);

        while (testCases > 0) {
            String line = in.nextLine();
            Matcher m = p.matcher(line);

            int num = 0;
            while (m.find()) {
                System.out.println(m.group(2));
                num++;
            }
            if (num == 0)
                System.out.println("NONE");

            testCases--;
        }
    }

    public static void main33(String[] args) {
        Scanner in = new Scanner(System.in);
        BigDecimal x = in.nextBigDecimal();
        BigDecimal y = in.nextBigDecimal();

        System.out.println(x.add(y));
        System.out.println(x.multiply(y));
    }
}
