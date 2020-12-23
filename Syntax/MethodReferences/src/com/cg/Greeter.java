package com.cg;

public class Greeter {

    public static void print(String message) {
    }

    public void instancePrint(String message) {
    }

    public Greeter(String message) {
        System.out.println(message);
    }


    public static void show() {


        //Class/Object::method

        //greet(message -> System.out.println(message));
        greet(System.out::println);


        //greet(message -> print(message));
        greet(Greeter::print);

    }

    public static void showWithConstructor() {

        // with instance method
        var demo = new Greeter("hi");
        greet(message -> demo.instancePrint(message));
        greet(demo::instancePrint);

        greet(message -> new Greeter(message));
        // with method reference

        greet(Greeter::new);

    }

    public static void greet(Printer printer) {
        printer.print("Hi");
    }
}
