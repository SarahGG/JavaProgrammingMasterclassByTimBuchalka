package com.company;

public class Main {

    public static void main(String[] args) {
	String numberAsString = "2018.125";
        System.out.println("numberAsString = " + numberAsString);

        double number = Double.parseDouble(numberAsString);
        System.out.println("number = " + number);

        numberAsString += 1;
        number +=1;

        System.out.println("numberAsAtring = " + numberAsString);
        System.out.println("number = " + number);


    }
}
