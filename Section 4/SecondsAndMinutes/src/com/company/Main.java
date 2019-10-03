package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(3945));

    }

    private static String getDurationString(int minutes, int seconds) {
        String response;

        if(minutes < 0 || seconds < 0 || seconds > 59) {
            return "Invalid value.";
        }

        int hours = 0;

        minutes += seconds / 60;
        seconds = seconds % 60;

        hours += minutes / 60;
        minutes = minutes % 60;

        return hours + "h " + minutes + "m " + seconds + "s";
    }

    private static String getDurationString(int seconds) {
        if(seconds < 0) {
            return "Invalid response";
        }

        int minutes = 0;
        int hours = 0;

        minutes = seconds / 60;
        seconds = seconds % 60;

        hours = minutes / 60;
        minutes = minutes % 60;

        return hours + "h " + minutes + "m " + seconds + "s";
    }
}
