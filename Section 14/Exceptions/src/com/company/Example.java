package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int result = divide(scan);
        System.out.println("result is " + result);
    }

    private static int divide(Scanner scan) {
        int x, y;

        try {
            x = getInt(scan);
            y = getInt(scan);
        } catch(NoSuchElementException e)  {
            throw new ArithmeticException("no suitable input");
        }

        System.out.println("x is " + x + ", y is " + y);
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("attempt to divide by zero");
        }
    }

    private static int getInt(Scanner scan) {
        System.out.println("Please enter an integer ");

        while (true) {
            try {
                return scan.nextInt();
            } catch(InputMismatchException e) {
                scan.nextLine();
                System.out.println("Please enter a number using only the digits 0 through 9.");
            }
        }
    }
}
