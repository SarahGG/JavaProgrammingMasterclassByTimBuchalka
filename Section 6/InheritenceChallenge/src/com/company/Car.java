package com.company;

public class Car extends Vehicle {
    private int mirrors;

    public Car(int wheels, int seats, int doors, int mirrors) {
        super(wheels, seats, doors);
        setMirrors(mirrors);
    }

    public int getMirrors() {
        return mirrors;
    }

    public void setMirrors(int mirrors) {
        this.mirrors = mirrors;
    }


}
