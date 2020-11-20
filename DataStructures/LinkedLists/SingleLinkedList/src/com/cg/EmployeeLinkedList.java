package com.cg;


// single linked list best used when want to insert and remove from front of list

// can continue to grow without needed to resize

// when memory is a concern though each node takes up more space then it would in an array

public class EmployeeLinkedList {

    private EmployeeNode head;

    private int size;

    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public void printList() {
        EmployeeNode current = head;

        while(current != null){
            System.out.println(current);
            current = current.getNext();
        }
    }

    public EmployeeNode removeFirstNode() {

        if (isEmpty()){
            return null;
        }

        EmployeeNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
