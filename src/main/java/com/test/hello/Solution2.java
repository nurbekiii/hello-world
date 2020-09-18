package com.test.hello;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Write your Checker class here

class Checker implements Comparator {
    public int compare(Object o1, Object o2) {
        Player s1 = (Player) o1;
        Player s2 = (Player) o2;

        if (s1.score == s2.score) {
            return s1.name.compareTo(s2.name);
        } else if (s1.score < s2.score)
            return 1;
        else
            return -1;
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Solution2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}