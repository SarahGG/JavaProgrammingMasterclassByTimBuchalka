package com.company;

public class Main {

    public static void main(String[] args) {
	// Get the MIN and MAX value of floats and doubles
        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;

        System.out.printf("The Float value range is from %f to %f%n", myMinFloatValue, myMaxFloatValue);
    }
}
