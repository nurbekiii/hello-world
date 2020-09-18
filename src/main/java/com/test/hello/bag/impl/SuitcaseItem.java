package com.test.hello.bag.impl;

import com.test.hello.bag.Suitcase;

/**
 * @author NIsaev on 19.08.2020
 */
public class SuitcaseItem implements Suitcase {
    private String name;
    private boolean hasWheels;

    public SuitcaseItem(String name, boolean hasWheels) {
        this.name = name;
        this.hasWheels = hasWheels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasWheels() {
        return hasWheels;
    }

    public void setHasWheels(boolean hasWheels) {
        this.hasWheels = hasWheels;
    }

    @Override
    public void showDecription() {
        System.out.println(toString());
    }

    @Override
    public void pull() {
       if(!hasWheels) {
           System.out.println("I can not be pulled. ERROR! ALARM!");
           return;
       }

        System.out.println("I can be pulled");
    }

    @Override
    public void push() {
        if(!hasWheels) {
            System.out.println("I can not be pushed. ERROR! ALARM!");
            return;
        }

        System.out.println("I can be pushed");
    }

    @Override
    public void carry() {
        System.out.println("I am carried by my hands");
    }

    @Override
    public void showShape() {
        System.out.println("прямоугольный с круглыми краями");
    }

    @Override
    public String toString() {
        return "SuitcaseItem{" +
                "name='" + name + '\'' +
                ", hasWheels=" + hasWheels +
                '}';
    }
}
