package com.company;

public class Main {

    public static void main(String[] args) {
        printDayOfTheWeek(3);
        printDayOfTheWeek(2);
        printDayOfTheWeek(7);

    }

    private static void printDayOfTheWeek(int day) {
        String dayOfTheWeek;

        switch (day) {
            case 0:
                dayOfTheWeek = "Sunday";
                break;
            case 1:
                dayOfTheWeek = "Monday";
                break;
            case 2:
                dayOfTheWeek = "Tuesday";
                break;
            case 3:
                dayOfTheWeek = "Wednesday";
                break;
            case 4:
                dayOfTheWeek = "Thursday";
                break;
            case 5:
                dayOfTheWeek = "Friday";
                break;
            case 6:
                dayOfTheWeek = "Saturday";
                break;
            default:
                dayOfTheWeek = "Invalid Day";
        }

        System.out.println(dayOfTheWeek);
    }
}
