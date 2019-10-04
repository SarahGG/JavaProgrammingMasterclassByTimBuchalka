package com.company;

public class Fish extends Animal {
    private int gills;
    private int fins;
    private int eyes;

    public Fish(int brain, int body, int size, int weight, String name, int gills, int fins, int eyes) {
        super(1, 1, size, weight, name);
        this.gills = gills;
        this.fins = fins;
        this.eyes = eyes;
    }

    public void swim(int speed) {
        super.move(speed);
    }

    public int getGills() {
        return gills;
    }

    public void setGills(int gills) {
        this.gills = gills;
    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }
}
