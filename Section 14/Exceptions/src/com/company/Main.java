package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = 98;
        int y = 0;
        System.out.println(divideLBYL(x, y));
        System.out.println(divideEAFP(x, y));
//        System.out.println(divide(x, y)); // commented this out because it causes an error (which was intentional)

        // =================== next part of the lesson

        x = getInt(scan);
        System.out.println("x is " + x);

        x  = getIntLBYL(scan);
        System.out.println("x is " + x);

    }

    private static int getInt(Scanner scan) {
        return scan.nextInt();
    }

    private static int getIntLBYL(Scanner scan) {
        boolean isValid = true;
        System.out.println("please enter an Integer: ");
        String input = scan.next();

        for(int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }

        if(isValid) {
            return Integer.parseInt(input);
        } else {
            return 0;
        }
    }

    private static int divideLBYL (int x, int y) {
        if(y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }

    private static int divide(int x, int y) {
        return x / y;
    }
}
