package com.cg;

public class Main {

    public static void main(String[] args) {

        Tree intTree = new Tree();

        intTree.insert(23);
        intTree.insert(66);
        intTree.insert(13);
        intTree.insert(10);
        intTree.insert(73);

        intTree.traverseInOrder();

        System.out.println(intTree.get(23).getData());
        System.out.println(intTree.get(999));

        System.out.println(intTree.max());
        System.out.println(intTree.min());



    }
}
