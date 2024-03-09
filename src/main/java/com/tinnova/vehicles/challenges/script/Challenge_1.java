package com.tinnova.vehicles.challenges.script;

public class Challenge_1 {

    public static void main(String[] args) {
        VoteCalculator calculator = new VoteCalculator(1000, 800, 150, 50);
        System.out.println("Percentage of valid votes: " + calculator.percentageValidVotes() + "%");
        System.out.println("Percentage of blank votes: " + calculator.percentageVotesWhite() + "%");
        System.out.println("Percentage of invalid votes: " + calculator.percentageNullVotes() + "%");
    }
}