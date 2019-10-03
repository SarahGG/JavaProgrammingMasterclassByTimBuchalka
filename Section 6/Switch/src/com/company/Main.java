package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bugs have: \n"
                + "A) 4 legs\n"
                + "B) 6 legs\n"
                + "c) Blood vessels\n"
                + "D) A lot of friends\n"
                + "E) A preference for honey over vinegar\n"
                + "\nPlease enter your answer: ");


        Scanner scanner = new Scanner(System.in);
        char answer = Character.toUpperCase(scanner.next().charAt(0));

        switch(answer) {
            case 'A': case 'B': case 'C': case 'D': case 'E':
                System.out.println("You chose answer " + answer);
                break;
            default:
                System.out.println("Answer not found.");
        }
    }
}
