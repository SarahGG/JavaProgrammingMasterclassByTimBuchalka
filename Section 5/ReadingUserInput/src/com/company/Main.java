package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year of birth: ");

        if (scanner.hasNextInt()) {
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine(); // handle nextline character

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            int age = 2018 - yearOfBirth;

            if(age >= 0 && age <= 100) {
                System.out.println(name
                        + ", you're "
                        + age + " years old.");
            } else {
                System.out.println("Invalid year of birth");
            }
        } else {
            System.out.println("Please enter a valid number");
        }

        scanner.close();
    }
}
