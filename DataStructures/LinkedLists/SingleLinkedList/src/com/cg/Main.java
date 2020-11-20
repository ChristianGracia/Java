package com.cg;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(new Employee("cc", "d", 123));
        list.addToFront(new Employee("dd", "l", 126));
        list.addToFront(new Employee("eee", "lll", 125));

        list.printList();

        System.out.println(list.getSize());

        list.removeFirstNode();

        list.printList();
        System.out.println(list.getSize());





    }
}
