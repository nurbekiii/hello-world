package com.test.hello;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution35 {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        if (s == null || s.isEmpty())
            return 0;

        char chars [] = s.toCharArray();

        int len = s.length();
        int num = 0;
        boolean isLong = (len > 20);
        for(int i = 0, j = len-1; i< len-1; i++, j--){
            if (chars[i] == chars[i+1]) {
                num++;
            }

            if(isLong){
                if(i+1>= j)
                    break;

                if (chars[j-1] == chars[j]) {
                    num++;
                }
            }
        }

        return num;

        /*int num = 0;
        int pos = 0;
        char chSS = 0;
        while (pos < s.length()-1) {
            if (s.length() == 1)
                return num;

            if (s.charAt(pos) == s.charAt(pos + 1)) {
                StringBuilder sss = new StringBuilder(s);
                sss.setCharAt(pos, chSS);
                s = sss.toString().trim();
                num++;
            } else {
                pos++;
            }
        }
        return num;*/
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/DANNYE/44.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

