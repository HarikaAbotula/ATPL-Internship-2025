package com.aaslin.assignments;

import java.util.*;

public class VotingSystem {

    static Map<String, Integer> votes = new HashMap<>();

    public static void main(String[] args) {
  
        addVote("Mike");
        addVote("Nancy");
        addVote("Mike");
        addVote("Eleven");
        addVote("Mike");
        addVote("Dustin");
        addVote("Nancy");

        showResults();
        findWinner();
    }

    public static void addVote(String candidate) {
        // If candidate doesn't exist, default to 0
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
    }

    public static void showResults() {
        System.out.println("   Voting Results  ");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " votes");
        }
    }

    public static void findWinner() {
        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        System.out.println("\n Winner: " + winner + " with " + maxVotes + " votes.");
    }
}
