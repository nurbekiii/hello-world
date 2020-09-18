package com.test.hello;

import java.util.*;

public class Solution45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
        }

        Set<Integer> set = null;
        List list = new ArrayList(m);

        int max = 0;
        int num = 0;
        while (num < n) {
            deque.pop();
            list.addAll(deque);
            num++;
            if (num >= m) {
                set = new HashSet<>(list);
                if (set.size() > max)
                    max = set.size();

                list.remove(0);
            }

            if(max == m)
                break;


        }
        System.out.println(max);
    }
}




