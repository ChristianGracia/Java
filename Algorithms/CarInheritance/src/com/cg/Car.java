package com.cg;

public abstract class Car {

    private Boolean isSedan;
    private String seats;

    Boolean getIsSedan() {
        return isSedan;
    }

    String getSeats() {
        return seats;
    }

    abstract String getMileage();
}
