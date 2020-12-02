package com.cg;

public class Main {

    public static void main(String[] args) {

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(new Employee("cc", "d", 123));
        list.addToFront(new Employee("dd", "l", 126));
        list.addToFront(new Employee("eee", "lll", 125));

        list.addToEnd(new Employee("ffff", "lll", 125));

        list.printList();

        list.removeFirstNode();

        list.printList();

        list.removeLastNode();

        list.printList();

	
    }
}
