package com.company;

import java.util.regex.Matcher;
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

    private static void challenge2() {
        buildMenu("Challenge 2",
                "\tNow write a regular expression that will match \"I want a bike.\" and \"I want a ball.\".\n" +
                        "\tVerify your answer using the matches() method.");

        String ch2regexPattern = "^I want a (bike|ball).$";
        System.out.println("\t\tregex pattern: " + ch2regexPattern);
        String ch2StringBall = "I want a ball.";
        System.out.println("\t\tRegex matches \"" + ch2StringBall + "\": " + Pattern.matches(ch2regexPattern, ch2StringBall));
        String ch2StringBike = "I want a bike.";
        System.out.println("\t\tRegex matches \"" + ch2StringBike + "\": " + Pattern.matches(ch2regexPattern, ch2StringBike));
    }

    public static void main(String[] args) {
        challenge1();
        challenge2();
    }

    private static void buildMenu(String menuMessage, String challengeMessage) {
        System.out.println("\n\t============================");
        System.out.println("\t" + menuMessage);
        System.out.println("\t============================");
        System.out.println(challengeMessage);
        System.out.println("\t============================\n");
    }
}
