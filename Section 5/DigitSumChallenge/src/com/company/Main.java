package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(-125));
        System.out.println(sumDigits(32123));
    }
    private static int sumDigits(int number) {
        number = Math.abs(number);

        int sum = 0;

        while(number > 0) {
            sum += number % 10;
            number /=  10;
        }

        return sum;
    }
}
