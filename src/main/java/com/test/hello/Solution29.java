package com.test.hello;

import java.util.*;

public class Solution29 {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        int lenNote = note.length;
        int num = 0;

        Arrays.parallelSort(magazine);
        Arrays.parallelSort(note);

        Hashtable<String, Integer> magTable = countOccurences(magazine);
        Hashtable<String, Integer> noteTable = countOccurences(note);
        Set<String> set = uniqueWords(note);
        for (String word : set) {
            int num1 = 0;
            try {
                num1 = magTable.get(word);
            } catch (Exception t) {
                System.out.println("No");
                return;
            }
            if(num1 == 0){
                System.out.println("No");
                return;
            }

            int num2 = noteTable.get(word);

            if (num1 < num2) {
                System.out.println("No");
                return;
            }

            if (num1 >= num2) {
                num++;
            }
        }

        System.out.println(num >= lenNote ? "Yes" : "No");
    }

    static Hashtable<String, Integer> countOccurences(String[] words) {

        Hashtable<String, Integer> table = new Hashtable<>();
        for (String word : words) {
            try {
                int res = table.get(word);
                res++;
                table.put(word, res);
            } catch (Exception t) {
                table.put(word, 1);
            }
        }

        return table;
    }

    static Set<String> uniqueWords(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        return set;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
