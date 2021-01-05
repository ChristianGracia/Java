package com.cg;

public class Main {

    public static void main(String[] args) {

        Tree intTree = new Tree();

        intTree.insert(25);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(32);
        intTree.insert(17);


        intTree.traverseInOrder();
        System.out.println();
        intTree.traversePreOrder();
        System.out.println();

        System.out.println(intTree.get(25).getData());
        System.out.println(intTree.get(999));

        System.out.println(intTree.max());
        System.out.println(intTree.min());

        intTree.delete(10);

        intTree.traverseInOrder();

    }
}
