package com.example.vehiclebuyingapp.model;

public class Car {
    private String type;
    private String color;
    private int price;
    private int year;

    public Car(String type, String color, int price, int year) {
        this.type = type;
        this.color = color;
        this.price = price;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }
}
