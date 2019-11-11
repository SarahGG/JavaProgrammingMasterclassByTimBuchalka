package com.company;

public class Vehicle {
    private double speed;
    private int wheels;
    private int seats;
    private int doors;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

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

    public Vehicle(double speed, int wheels, int seats, int doors) {
        this.speed = speed;
        this.wheels = wheels;
        this.seats = seats;
        this.doors = doors;
    }
}
