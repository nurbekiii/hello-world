package com.test.hello;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author NIsaev on 02.03.2020
 */
public class Main5 {

    public static void main(String[] args) {
        Runtime.getRuntime().runFinalization();
        char xx= 'x';
        System.out.println((int)xx);

        double p = 3.1415;
        System.out.println(p);

    }

    public static void main55(String[] args) {


        String str = "baaabbabbb";

        //String regex = "(ba|ba|ab|ab?)*";

        String regex = "aab{2}|ab{2}|aba{2}b|ba{2}";



        Pattern phone = Pattern.compile(regex);
        String[] tests = {str};
        //for (String s : tests) {
            Matcher m = phone.matcher(str);
            m.find();
            System.out.println("group(0) = " + m.group(0));
            System.out.println("group(1) = " + m.group(1));
            System.out.println("group(2) = " + m.group(2));
            System.out.println("group(3) = " + m.group(3));
            System.out.println("group(4) = " + m.group(4));

        //}

    }
}
