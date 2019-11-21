package com.company;

public class Main {

    public static void main(String[] args) {
        // Create a base class called Car.
        // It should hae a few fields that would be appropriate for a generic car class, like engine, wheels, etc.
        // Make sure that some parameters need to be passed upon initialization.
        // Create getters and setters.
        // create some methods like start, accelerate, and brake.
        // Now, make 3 classes that extend Car and demonstrate polymorphism.

        System.out.println("We're about the build a new car.");
        Car newCar = new Car(2, 3, "Ford", "Mustang", 1950);
        FordFiesta newFiesta = new FordFiesta(1992);


    }
}
