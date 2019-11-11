package com.company;

import java.awt.desktop.AppReopenedEvent;

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

    int getWheels() {
        return wheels;
    }

    private void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getSeats() {
        return seats;
    }

    private void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    private void setDoors(int doors) {
        this.doors = doors;
    }

    Vehicle(int wheels, int seats, int doors) {
        setSpeed(0.00d);
        setWheels(wheels);
        setSeats(seats);
        setDoors(doors);
    }
}
