package com.cg;

public class Main {

    public static void main(String[] args) {

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(new Employee("cc", "d", 123));
        list.addToFront(new Employee("dd", "l", 126));
        list.addToFront(new Employee("eee", "lll", 125));

        list.addToEnd(new Employee("ffff", "lll", 125));

        list.printList();

        System.out.println("----------------------------------");

        list.removeFirstNode();

        list.printList();

        System.out.println("----------------------------------");

        list.removeLastNode();

        list.printList();

        System.out.println("----------------------------------");

        Employee employee = new Employee("ffff", "lll", 125);

        list.addToEnd(employee);

        Employee newEmployee = new Employee("lol", "new", 125);

        list.printList();

        System.out.println("----------------------------------");

        list.addBeforeIndex(newEmployee, employee);

        list.printList();


	
    }
}
