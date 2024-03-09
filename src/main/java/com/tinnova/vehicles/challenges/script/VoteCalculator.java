package com.tinnova.vehicles.challenges.script;

public class VoteCalculator {

    private final int totalVoters;
    private final int validVotes;
    private final int whiteVotes;
    private final int nullVotes;

    public VoteCalculator(int totalVoters, int validVotes, int whiteVotes, int nullVotes) {
        this.totalVoters = totalVoters;
        this.validVotes = validVotes;
        this.whiteVotes = whiteVotes;
        this.nullVotes = nullVotes;
    }

    public double percentageValidVotes() {
        return ((double) validVotes / totalVoters) * 100;
    }

    public double percentageVotesWhite() {
        return ((double) whiteVotes / totalVoters) * 100;
    }

    public double percentageNullVotes() {
        return ((double) nullVotes / totalVoters) * 100;
    }
}