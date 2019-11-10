package com.company;

public class Vehicle {
    private int wheels;
    private int seats;
    private int doors;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public Vehicle(int wheels, int seats, int doors) {
        this.wheels = wheels;
        this.seats = seats;
        this.doors = doors;
    }
}
