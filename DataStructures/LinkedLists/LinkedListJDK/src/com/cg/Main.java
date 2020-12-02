package com.cg;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Employee alpha = new Employee("cc", "d", 123);
        Employee beta = new Employee("dd", "l", 126);
        Employee gamma = new Employee("eeffe", "lll", 125);
        Employee delta = new Employee("eedde", "lll", 125);
        Employee epsilon = new Employee("eede", "lll", 125);

        LinkedList<Employee> list = new LinkedList<>();

        list.addFirst(alpha);
        list.addFirst(beta);
        list.addFirst(gamma);
        list.addFirst(delta);

        Iterator iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("------------------------------");

        list.addLast(epsilon);

        iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("------------------------------");

        list.removeFirst();

        iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
