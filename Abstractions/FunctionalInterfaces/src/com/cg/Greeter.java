package com.cg;

public class Greeter {


    public static void show() {
        greet(new ConsolePrinter());
    }

    public static void greet(Printer printer) {
        printer.print("hi");
    }
}
