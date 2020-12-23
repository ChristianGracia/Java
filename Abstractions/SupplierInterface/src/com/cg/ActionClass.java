package com.cg;

import java.util.function.Supplier;

public class ActionClass {
    public static void show() {
        Supplier<Double> getRandom = () -> Math.random();
        //lazy evaluation, value is not calculated until it is called
        Double random = getRandom.get();
        System.out.println(random);

    }
}
