package com.cg;

public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public boolean isFull(){
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public void insert(int value) {
        if (isFull()){
            throw new IndexOutOfBoundsException("Heap is full");
        }
    }
}
