package com.test.hello;

/**
 * @author NIsaev on 09.03.2020
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.in;

class Prime {

    public Prime checkPrime(int... check) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < check.length; i++) {
            int num = check[i];
            if (num <= 1)
                continue;

            if (isPrime(num)) {
                set.add(new Integer(num));
            }
        }

        String str = "";
        for (int num : set) {
            str += "" + num + " ";
        }
        System.out.println(str.trim());

        return this;
    }

    private boolean isPrime(int num) {
        if (num == 1)
            return false;

        if (num <= 3)
            return true;

        int k = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                k++;
        }
        return (k <= 2);
    }
}

public class Solution17 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
