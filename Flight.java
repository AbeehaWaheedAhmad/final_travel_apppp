package com.example.final_travel_apppp;

public class Flight {
    private String name;
    private String details;
    private String price;

    public Flight(String name, String details, String price) {
        this.name = name;
        this.details = details;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getPrice() {
        return price;
    }
}
