package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    private static int divideLBYL (int x, int y) {
        if(y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int dividEAFP(int x, int y) {
        try {
            return x / y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }
}
