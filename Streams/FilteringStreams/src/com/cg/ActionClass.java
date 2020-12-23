package com.cg;

import java.util.List;
import java.util.function.Predicate;

public class ActionClass {

    public static void show(){

        List<Post> list = List.of(new Post("a", 5), new Post("b", 10), new Post("c", 20));

        list.stream()
                .filter(post -> post.getLikes() > 10).forEach(post -> System.out.println(post.getTitle()));

        Predicate<Post> isPopular = p -> p.getLikes() > 10;

        list.stream()
                .filter(isPopular).forEach(post -> System.out.println(post.getTitle()));
    }
}
