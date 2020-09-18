package com.test.hello.bag.impl;

import com.test.hello.bag.Bag;

/**
 * @author NIsaev on 19.08.2020
 */
public class StringBag implements Bag {
    private String name;
    private String shape;

    public StringBag(String name, String shape) {
        this.name = name;
        this.shape = shape;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public void carry() {
        System.out.println("I am carried by my ropes");
    }

    @Override
    public void showShape() {
        System.out.println(shape);
    }

    @Override
    public void showDecription() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "StringBag{" +
                "name='" + name + '\'' +
                ", shape='" + shape + '\'' +
                '}';
    }
}
