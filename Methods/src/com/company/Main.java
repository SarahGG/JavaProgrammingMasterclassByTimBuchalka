package com.company;

public class Main {

    public static void main(String[] args) {
        int finalScore = calculateScore(true, 800,5, 100);
        finalScore = calculateScore(true, 10000, 8, 200);

        displayHighScorePosition("Henry", calculateHighScorePosition(1500));
        displayHighScorePosition("Samantha", calculateHighScorePosition(900));
        displayHighScorePosition("Rami", calculateHighScorePosition(400));
        displayHighScorePosition("Kiko", calculateHighScorePosition(50));
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if(gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            System.out.println("Your final score was " + finalScore);
            return finalScore;
        } else {
            return -1;
        }
    }

    public static void displayHighScorePosition(String playerName, int tablePosition) {
        System.out.println(playerName + " is in the " + tablePosition + " position");
    }

    public static int calculateHighScorePosition(int playerScore) {
        int tablePosition = 4;

        if(playerScore >= 1000) {
            tablePosition = 1;
        } else if(playerScore >= 500) {
            tablePosition = 2;
        } else if (playerScore >= 100) {
            tablePosition = 3;
        }

        return tablePosition;
    }
}
