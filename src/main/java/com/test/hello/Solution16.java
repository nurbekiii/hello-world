package com.test.hello;

/**
 * @author NIsaev on 09.03.2020
 */

import java.math.BigDecimal;
import java.util.Scanner;

//2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373226251982

public class Solution16 {
    public static boolean isPrime(BigDecimal check) {
        if (check.equals(new BigDecimal(1)))
            return false;

        if (check.compareTo(new BigDecimal(3)) <= 0)
            return true;

        BigDecimal remainder = check.remainder(new BigDecimal(2));
        if (BigDecimal.ZERO.compareTo(remainder) == 0) {
            return false;
        }

        BigDecimal remainder2 = null;
        int num = 2;

        final BigDecimal control = new BigDecimal(100000000);

        BigDecimal i = new BigDecimal(2);
        BigDecimal tail = (check.compareTo(new BigDecimal(100)) <= 0 ? check : check.divide(new BigDecimal(5))).subtract(new BigDecimal(1));
        while (i.compareTo(check) <= 0) {
            if (check.compareTo(new BigDecimal(20)) > 0 && i.compareTo(control) > 0)
                break;

            if (tail.compareTo(i) <= 0)
                break;

            remainder = check.remainder(i);
            remainder2 = check.remainder(tail);
            if (BigDecimal.ZERO.compareTo(remainder) == 0) {
                num++;
            }

            if (BigDecimal.ZERO.compareTo(remainder2) == 0) {
                num++;
            }

            i = i.add(new BigDecimal(1));
            tail = i.subtract(new BigDecimal(1));

            if (num > 2)
                break;
        }

        if (num == 2) {
            return (check.toBigInteger().isProbablePrime(1));
        }

        return (num <= 2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();
        if (isPrime(new BigDecimal(n)))
            System.out.println("prime");
        else
            System.out.println("not prime");


        scanner.close();
    }

}
