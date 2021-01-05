package com.cg;

public class WagonR extends Car {

    private String seats;
    private Boolean isSedan = false;

    private String mileage;

    public WagonR(int mileage) {
        this.mileage = "" + mileage;
        this.seats = "4";
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
