package com.test.hello;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author NIsaev on 03.03.2020
 */
public class Solution11 {

    public static void main(String[] args){
        Class student = Student.class;
        Method[] methods = student.getMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method ss: methods){

            methodList.add(ss.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }

}
