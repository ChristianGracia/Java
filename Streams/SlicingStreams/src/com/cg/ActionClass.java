package com.cg;

import java.util.List;

public class ActionClass {
    public static void show() {
        List<Post> list = List.of(new Post("a", 5), new Post("b", 10), new Post("c", 20));

        list.stream().limit(2).forEach(p -> System.out.println(p.getTitle()));

        list.stream().skip(1).limit(1).forEach(p -> System.out.println(p.getTitle()));

        list.stream().takeWhile(m -> m.getLikes() < 20).forEach(p -> System.out.println(p.getTitle()));


    }
}
