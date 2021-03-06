package com.cg;

import java.util.List;

public class ActionClass {

    public static void show(){

        List<Post> list = List.of(new Post("a", 5), new Post("b", 10), new Post("c", 20));

        list.stream()
                .map(post -> post.getTitle())
                .forEach(title -> System.out.println(title));

    }
}
