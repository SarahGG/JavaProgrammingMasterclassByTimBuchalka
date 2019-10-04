package com.company;

public class Dog extends Animal {
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(int brain, int weight, String name, int eyes, int legs, int tail, int teeth, String coat) {
        super(brain, 1,1, weight, name);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    public void chew() {
        System.out.println("The " + this.getName() + " chews the food only a little.");
    }

    public void walk() {
        System.out.println("Dog.walk() activated.");
        super.move(5);
    }

    public void run() {
        System.out.println("Dog.run() activated.");
        move(10);
    }

    @Override
    public void eat() {
        System.out.println("The " + this.getName() + " is ravenous!");
        chew();
        super.eat();
    }

    @Override
    public void move(int speed) {
        System.out.println("That's a fast dog!");
        super.move(speed);
    }
}
