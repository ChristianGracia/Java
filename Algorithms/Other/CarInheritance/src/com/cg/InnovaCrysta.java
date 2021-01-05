package com.cg;

public class InnovaCrysta extends Car {
    private String mileage;
    private String seats = "6";
    private Boolean isSedan = false;

    public InnovaCrysta(int mileage) {
        this.mileage = "" + mileage;
    }

    @Override
    public Boolean getIsSedan() {
        return isSedan;
    }

    @Override
    public String getSeats() {
        return seats;
    }

    String getMileage() {
        return String.format("%s kmpl", mileage);
    }
}
