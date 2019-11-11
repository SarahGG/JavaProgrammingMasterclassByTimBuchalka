package com.company;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(4, 5, 4, 3);
        System.out.println("Our car has " + car.getWheels() + " wheels!");

        System.out.println("Let's go somewhere!");
        car.setGear(1);
        car.setSpeed(10.00);
        car.setGear(6);
        car.setSpeed(50.00);

        FordMustang myFord = new FordMustang(2,7);
        System.out.println("We've got another car!");

        myFord.setGear(9);
    }
}
