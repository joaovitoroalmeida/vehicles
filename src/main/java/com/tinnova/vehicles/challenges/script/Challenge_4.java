package com.tinnova.vehicles.challenges.script;

public class Challenge_4 {
    public static void main(String[] args) {
        int limit = 10;
        int sum = SumMultiples.sumMultiples(limit);
        System.out.println("The sum of all multiples of 3 or 5 up to " + limit + " is: " + sum);
    }
}