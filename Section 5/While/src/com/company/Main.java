package com.company;

public class Main {

    public static void main(String[] args) {
        int num = 4;
        int finishedNum = 20;
        int evenNumbersFound = 0;

        while(num <= finishedNum) {
            num++;

            if(!isEvenNumber(num)) {
                continue;
            }

            if (evenNumbersFound == 5) {
                break;
            }

            evenNumbersFound++;
            System.out.println("Even number " + num);
        }

        System.out.println("5 even numbers found");
    }

    private static boolean isEvenNumber(int num) {
        if(num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
