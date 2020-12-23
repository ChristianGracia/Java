package com.cg;

import java.util.function.Function;

public class ActionClass {

    public static void show(){
        // params -> T = type of input, R = type of result
        Function<String, Integer> map = str -> str.length();
        int item = map.apply("egg");
        System.out.println(3);
    }
}
