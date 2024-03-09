package com.tinnova.vehicles.challenges.script;

public class Challenge_2 {

    public static void main(String[] args) {
        int[] vector = {5, 3, 2, 4, 7, 1, 0, 6};

        System.out.println("Vector before sorting:");
        for (int v : vector) {
            System.out.print(v + " ");
        }

        BubbleSort.bubbleSort(vector);

        System.out.println("\nVector after sorting:");
        for (int v : vector) {
            System.out.print(v + " ");
        }
    }

}
