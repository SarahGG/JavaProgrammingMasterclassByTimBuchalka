package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Integer max = null;
        Integer min = null;

        while(true) {
            System.out.print("Please enter a number: ");

            if (scan.hasNextInt()) {
                int num = scan.nextInt();

                // loading up min and max if they are blank
                if(max == null) {
                    max = num;
                    min = num;
                }

                // testing entered number against the min and max values.
                if(num > max) {
                    max = num;
                } else if (num < min) {
                    min = num;
                }
            } else {
                break;
            }

            scan.nextLine();
        }

        System.out.printf("The minimum is %d and the maximum is %d", min, max);

    }
}
