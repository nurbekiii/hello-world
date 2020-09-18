package com.test.hello.bag.impl;

/**
 * @author NIsaev on 19.08.2020
 */
public class WheeledBagItem extends SuitcaseItem{

    public WheeledBagItem(String name) {
        super(name, true);
    }

    @Override
    public void showShape() {
        System.out.println("прямоугольный");
    }



    @Override
    public String toString() {
        return "WheeledBagItem{" +
                "name='" + super.getName() + '\'' +
                ", hasWheels=true" +
                '}';
    }
}
