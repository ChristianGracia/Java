package com.cg;

public class Main {

    public static void main(String[] args) {

        WagonR wagon = new WagonR(22);
        InnovaCrysta innova = new InnovaCrysta(34);
        HondaCity honda = new HondaCity(11);

        listProperties(wagon);
        listProperties(innova);
        listProperties(honda);
    }

    public static void listProperties(Car car) {
        System.out.println("Car is a " + car.getIsSedan() + " It has " + car.getSeats() + " seats and " + car.getMileage());

    }

}
