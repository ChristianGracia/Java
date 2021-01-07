package com.cg;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(19);
        heap.insert(30);
        heap.insert(21);
        heap.insert(68);
        heap.insert(34);
        heap.insert(20);
        heap.insert(82);
        heap.insert(77);

        System.out.println(heap.peek());

        heap.printHeap();

        heap.delete(5);
        heap.printHeap();

        heap.delete(0);
        heap.printHeap();

    }
}
