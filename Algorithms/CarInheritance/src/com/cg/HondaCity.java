package com.cg;

public class HondaCity extends Car {
    private String mileage;
    private String seats = "4";
    private Boolean isSedan = true;

    public HondaCity(int mileage) {
        this.mileage = "" + mileage;
    }

    @Override
    public String getSeats() {
        return seats;
    }

    @Override
    public Boolean getIsSedan() {
        return isSedan;
    }

    String getMileage() {
        return String.format("%s kmpl", mileage);
    }
}
