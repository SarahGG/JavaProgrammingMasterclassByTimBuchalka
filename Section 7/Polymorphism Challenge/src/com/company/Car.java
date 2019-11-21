package com.company;

public class Car {
    private String model;
    private int year;
    private int wheels;
    private boolean isRunning;
    private int doors;
    private int mirrors;

    public Car(int doors, int mirrors, String make, String model, int year) {
        System.out.println("We're making a new " + make + " " + model + "!");
        setWheels(4);
        setRunning(false);
        setDoors(doors);
        setMirrors(mirrors);
        setMake(make);
        setModel(model);
        setYear(year);
    }

    public Car() {
        System.out.println("We're making a new Car!");
        setWheels(4);
        setRunning(false);
        setDoors(4);
        setMirrors(3);
    }

    private String make;


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        System.out.println("The make has been set to " + make);
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        System.out.println("The model has been set to " + model);
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        System.out.println("The year has been set to " + year);
        this.year = year;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        System.out.println("The wheels have been set to " + wheels);
        this.wheels = wheels;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        System.out.println("isRunning = " + running);
        isRunning = running;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        System.out.println("The doors have been set to " + doors);
        this.doors = doors;
    }

    public int getMirrors() {
        return mirrors;
    }

    public void setMirrors(int mirrors) {
        System.out.println("The mirrors have been set to " + mirrors);
        this.mirrors = mirrors;
    }
}
