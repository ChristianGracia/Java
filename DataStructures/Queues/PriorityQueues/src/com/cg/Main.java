package com.cg;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(37);
        pq.add(0);
        pq.add(35);
        pq.add(-34);
        pq.add(-22);

        System.out.println(pq.peek());

        pq.remove();

        System.out.println(pq.peek());

        pq.poll();

        System.out.println(pq.peek());

        //The remove() and poll() methods differ only in their behavior when the queue is empty: the remove() method throws an exception,
        // while the poll() method returns null.

        System.out.println(pq.remove(35));

        System.out.println(pq.peek());

        pq.add(-100);

        System.out.println(pq.peek());

        Object[] ints = pq.toArray();

        for(Object num : ints){
            System.out.println(num);
        }



    }
}
