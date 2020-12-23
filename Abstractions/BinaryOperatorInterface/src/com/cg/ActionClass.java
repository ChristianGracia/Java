package com.cg;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class ActionClass {

    public static void show(){
        BinaryOperator<Integer> add = (a,b) -> a + b;

        Integer result = add.apply(1, 2);
        System.out.println(result);

        // can use IntBinaryOperator as well, more efficient for Ints
        IntBinaryOperator add2 = (a, b) -> a + b;
        Integer result2 = add2.applyAsInt(1, 2);
        System.out.println(result2);

        Function<Integer, Integer> square = a -> a * a;

        Integer result3 = add.andThen(square).apply(1, 2);

        System.out.println(result3);
    }
}
