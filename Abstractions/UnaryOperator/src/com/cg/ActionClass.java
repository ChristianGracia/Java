package com.cg;

import java.util.function.UnaryOperator;

public class ActionClass {

    public static void show(){
        UnaryOperator<Integer> square = n -> n * n;
        UnaryOperator<Integer> increment =  n -> n + 1;

        Integer result = increment.andThen(square).apply(1);

        System.out.println(result);

    }
}
