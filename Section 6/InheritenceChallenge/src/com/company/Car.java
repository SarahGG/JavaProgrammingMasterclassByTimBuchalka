package com.company;

public class Car extends Vehicle {
    private int mirrors;
    private int gear;

    public Car(double speed, int wheels, int seats, int doors, int mirrors, int gear) {
        super(speed, wheels, seats, doors);
        setGear(gear);
        setMirrors(mirrors);
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getMirrors() {
        return mirrors;
    }

    public void setMirrors(int mirrors) {
        this.mirrors = mirrors;
    }

    @Override
    public void setSpeed(double speed) {
        if(getGear() == 0) {
            System.out.println("You can't move - Your car isn't in gear!");
        } else if( speed > ((gear * 10) + 10) ) {
            System.out.printf("Speed of %f is invalid. Maximum speed in gear %d is %f", speed, getGear(), (double)((gear * 10) + 10));
        } else if( speed < ((gear * 10) - 10) ) {
            System.out.printf("Speed of %f is invalid. Minimum speed in gear %d is %f", speed, getGear(), (double)((gear * 10) - 10) );
        } else {
            super.setSpeed(speed);
        }
    }
}
