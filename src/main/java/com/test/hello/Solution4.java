package com.test.hello;

import java.util.Scanner;
import java.util.Stack;

class Solution4 {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isStringBalanced(input));
        }

    }

    private static boolean isStringBalanced(String testString) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : testString.toCharArray()) {
            switch (c) {
                case '[':
                case '(':
                case '{':
                    stack.push(c);
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        // stack has to be empty, if not, the balance was wrong
        return stack.empty();
    }
}
