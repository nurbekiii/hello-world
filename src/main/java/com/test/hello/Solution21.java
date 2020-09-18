package com.test.hello;

import java.util.Scanner;
class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "^[[A-Z]|[a-z]][[A-Z]|[a-z]|[0-9]|[_]]{8,30}$";
    //"^[a-zA-Z0-9_]{8,15}$";
    //"^[a-zA-Z0-9]+([_]?[a-zA-Z0-9]+){8,15}$";

}


public class Solution21 {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
