package com.cg;

import java.util.function.Predicate;

public class ActionClass {
    public static void show(){
        Predicate<String> isLongerThen9 = str -> str.length() > 9;
        Boolean result = isLongerThen9.test("lol");
        Boolean result2 = isLongerThen9.test("lolololololol");
        System.out.println(result);
        System.out.println(result2);
    }

    public static void showChaining(){
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        Predicate<String> hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);

        Boolean result = hasLeftAndRightBraces.test("{key:value}");



        System.out.println(result);

        // using negate() to return the opposite of a predicate
        Predicate<String> doesntHaveLeftBrace = hasLeftBrace.negate();

    }
}
