package com.company;

public class Animal {
    private int brain;
    private int body;
    private int size;
    private int weight;
    private String name;

    public Animal(int brain, int body, int size, int weight, String name) {
        this.setBrain(brain);
        this.setBody(body);
        this.setSize(size);
        this.setWeight(weight);
        this.setName(name);
    }

    public void eat() {
        System.out.println(this.getName() + " has eaten");
    }

    public void move(int speed) {
        System.out.println(this.getName() + " is moving at " + speed + " speed.");
    }

    public int getBrain() {
        return brain;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
