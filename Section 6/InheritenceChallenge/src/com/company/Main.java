package com.company;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(0.00,4, 5, 4, 3, 0);
        System.out.println("Our car has " + car.getWheels() + " wheels!");

        System.out.println("Let's go somewhere!");
        car.setGear(1);
        car.setSpeed(10.00);
        car.setGear(7);
        car.setSpeed(50.00);
    }
}
