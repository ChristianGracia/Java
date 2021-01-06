package com.cg;

public class Main {

    //more expensive then iterative because all of the functional calls

    public static void main(String[] args) {
        int[] intArray = {-22, -15, 1, 7, 20, 35, 55};

        System.out.println(recursiveBinarySearch(intArray, -22));
        System.out.println(recursiveBinarySearch(intArray, 7));
        System.out.println(recursiveBinarySearch(intArray, 100));

    }

    public static int recursiveBinarySearch(int[] input, int value) {

        return recursiveBinarySearch(input, 0, input.length, value);

    }

    public static int recursiveBinarySearch(int[] input, int start, int end, int value) {

        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;

        if (input[midpoint] == value) {
            return midpoint;
        } else if (input[midpoint] < value) {
            return recursiveBinarySearch(input, midpoint + 1, end, value);
        } else {
            return recursiveBinarySearch(input, start, midpoint, value);
        }
    }
}
