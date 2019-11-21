package com.company;

import java.util.regex.Pattern;

public class Main {

    private static void challenge1() {
        buildMenu("Challenge 1",
                "\tWrite the string literal regular expression that will match the following String: \"I want a bike.\n" +
                        "\tUse String.matches() to verify your answer.");

        String challenge1String = "I want a bike.";
        System.out.println("\t\tString to match is: " + challenge1String);
        System.out.println("\t\tOur regex pattern is: " +  "\"^I want a bike.$\"");
        System.out.println("\t\tOur regex matches: " + Pattern.matches("^I want a bike.$", challenge1String));
    }

    public static void main(String[] args) {
        challenge1();l
    }

    private static void buildMenu(String menuMessage, String challengeMessage) {
        System.out.println("\n\t============================");
        System.out.println("\t" + menuMessage);
        System.out.println("\t============================");
        System.out.println(challengeMessage);
        System.out.println("\t============================\n");
    }
}
