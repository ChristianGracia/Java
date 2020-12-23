package com.cg;

import java.util.stream.Stream;

public class ActionClass {
    public static void showGenerate() {

        Stream<Object> stream = Stream
                .generate(() -> Math.random());
        stream
                .limit(4)
                .forEach(n -> System.out.println(n));


    }

    public static void showIterate() {
        Stream.iterate(1, n -> n + 1).limit(10).forEach(n -> System.out.println(n));
    }
}
