package com.cg;

import java.util.Comparator;
import java.util.List;

public class ActionClass {
    public static void show() {
        List<Post> list = List.of(new Post("b", 5), new Post("a", 10), new Post("c", 20));


        list.stream()
                .sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))
                .forEach(p -> System.out.println(p.getTitle()));

        // better way
        list.stream()
                .sorted(Comparator.comparing(p -> p.getTitle()))
                .forEach(p -> System.out.println(p.getTitle()));

        // betterer way with method reference
        list.stream()
                .sorted(Comparator.comparing(Post::getTitle))
                .forEach(p -> System.out.println(p.getTitle()));

        // use reverse for reverse data obviously

    }
}
