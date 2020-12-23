package com.cg;

import java.util.function.Function;

public class ActionClass {
    public static void show(){

        // string in format "key:value"
        // first: "key=value"
        // second: "{key=value}"

        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";

        String result = replaceColon
                        .andThen(addBraces)
                        .apply("key:value");

        //compose chains functions in reverse order
        String resultWithCompose = addBraces.compose(replaceColon).apply("key:value");


        System.out.println(result);
        System.out.println(resultWithCompose);

    }
}
