package com.company;

public class FordMustang extends Car {
    private int maxGear;

    FordMustang(int seats, int maxGear) {
        super(4, seats, 2, 2);
        setMaxGear(maxGear);
    }

    private int getMaxGear() {
        return maxGear;
    }

    private void setMaxGear(int maxGear) {
        this.maxGear = maxGear;
    }

    @Override
    public void setGear(int gear) {
        if(gear > getMaxGear()) {
            System.out.printf("Gear %d is invalid! Max gear possible is %d.", gear, getMaxGear());
        } else {
            super.setGear(gear);
        }
    }
}
