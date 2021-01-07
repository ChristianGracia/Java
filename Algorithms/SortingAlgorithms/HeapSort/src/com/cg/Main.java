package com.cg;

public class Main {

    public static void main(String[] args) {

        Heap heap = new Heap(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);

        heap.printHeap();

        heap.sort();

        heap.printHeap();

    }
    
}
