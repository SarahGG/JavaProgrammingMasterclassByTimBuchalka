package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);

        int sum = 0;
        int count = 1;

        do {
            System.out.printf("Please enter number #%d: ", count);

            if (scan.hasNextInt()) {
                sum += scan.nextInt();
                count++;
            } else {
                System.out.print("Invalid input.  ");
            }

            scan.nextLine(); // clearing the scanner

        } while (count <= 10);

        System.out.printf("The sum is %d%n", sum);
    }
}
