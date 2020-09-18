package com.test.hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Complete the classes below
class Flower {
    public String whatsYourName(){
        return "Flower";
    }
}

class Jasmine extends Flower {
    public String whatsYourName(){
        return "Jasmine";
    }
}

class Lily  extends Flower {
    public String whatsYourName(){
        return "Lily";
    }
}

class Region {
    public Flower flower;
    public Region(){
        flower = new Flower();
    }

    public Flower yourNationalFlower(){
        return flower;
    }

}

class WestBengal extends Region {
    public WestBengal(){
        super.flower = new Jasmine();
    }
}

class AndhraPradesh extends Region {
    public AndhraPradesh(){
        super.flower = new Lily();
    }

}


public class Solution12 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}
