package com.company;

public class Main {

    public static void main(String[] args) {
	    int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore);
        newScore = calculateScore(75);
        System.out.println("New score is " + newScore);
    }

    public static int calculateScore(String playerName, int score) {
        System.out.printf("Player %s scored %d points.%n", playerName, score);


        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.printf("Unnamed player scored %d points.%n", score);


        return score * 1000;
    }
}
