package com.company;

public class Main {

    public static void main(String[] args) {

        double firstDbl = 20.00;
        double secondDbl = 80.00;

        double sumOfDblsTimes100 = (firstDbl + secondDbl) * 100;
        System.out.println("Sum of Double * 100 = " + sumOfDblsTimes100);

        double remainder = sumOfDblsTimes100 % 40;
        System.out.println("Remainder = " + remainder);

        boolean remainderIsZero = remainder == 0;
        System.out.println("remainderIsZero = " + remainderIsZero);

        if(!remainderIsZero) {
            System.out.println("Got some remainder");
        }

    }
}
