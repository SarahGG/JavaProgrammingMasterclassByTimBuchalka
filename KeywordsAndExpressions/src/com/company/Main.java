package com.company;

public class Main {

    public static void main(String[] args) {
	// a mile is equal to 1.609344 km
        double kilometres = (100 * 1.609344);
        int highscore = 50;

        if(highscore == 50) {
            System.out.println("This is an expression.");
        }

        int score = 100;
        if(score > 99) {
            System.out.println("Your got the new high score!");
            score = 0;
        }
    }
}
