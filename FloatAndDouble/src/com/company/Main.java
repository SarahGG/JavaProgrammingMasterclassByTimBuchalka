package com.company;

public class Main {

    public static void main(String[] args) {
	// Get the MIN and MAX value of floats and doubles
        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;

        System.out.printf("The Float value range is from %f to %f%n", myMinFloatValue, myMaxFloatValue);
        System.out.printf("The Double value range is from %e to %e%n", myMinDoubleValue, myMaxDoubleValue);

        System.out.print("\n");

        int myIntValue = 5 / 2;
        float myFloatValue = 5f / 2f;
        double myDoubleValue = 5d / 2d;

        System.out.printf("My Int Value: %d%n" +
                "my Float Value: %f%n" +
                "My Double Value: %f%n",
                myIntValue, myFloatValue, myDoubleValue);

        System.out.print("\n");

    }
}
