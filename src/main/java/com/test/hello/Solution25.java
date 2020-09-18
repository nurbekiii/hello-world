package com.test.hello;

import java.util.*;

class Player1 {
    String name;
    int score;

    Player1(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker1 implements Comparator<Player1> {
    // complete this method
    public int compare(Player1 a, Player1 b) {
        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        } else if (a.score < b.score)
            return 1;
        else
            return -1;
    }

}


public class Solution25 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player1[] player = new Player1[n];
        Checker1 checker = new Checker1();

        for(int i = 0; i < n; i++){
            player[i] = new Player1(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}