package com.test.hello.bag.impl;

import com.test.hello.bag.Bag;
import com.test.hello.bag.Suitcase;

/**
 * @author NIsaev on 19.08.2020
 */
public class Main55 {

    public static void main(String[] args) {
        Bag bagIkea = new BagItem("Ikea", "квадратный, небольшой");
        bagIkea.showDecription();
        bagIkea.carry();
        System.out.println("--------------------------");

        Bag bagAvoska = new StringBag("Avoska", "овальный");
        bagAvoska.showDecription();
        bagAvoska.carry();
        System.out.println("--------------------------");

        Suitcase bagNoWheels = new SuitcaseItem("Чемодан", false);
        bagNoWheels.showDecription();
        bagNoWheels.pull();
        bagNoWheels.push();
        System.out.println("--------------------------");

        Suitcase bagWithWheels = new SuitcaseItem("Чемодан на колесах", true);
        bagWithWheels.showDecription();
        bagWithWheels.pull();
        bagWithWheels.push();
        System.out.println("--------------------------");

        Suitcase bagGranny = new WheeledBagItem("GrandMoms Wheeled Bag");
        bagGranny.showDecription();
        bagGranny.carry();
        bagGranny.pull();
        bagGranny.push();
        System.out.println("--------------------------");
    }
}
