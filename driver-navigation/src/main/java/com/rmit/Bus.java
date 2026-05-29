package com.rmit;

public class Bus {
    private String busID;
    private int capacity;
    private double fuelLevel;
    private String fuelType; // Diesel, Hybrid, Electricity

    public Bus(String busID, int capacity, double fuelLevel, String fuelType) {
        this.busID = busID;
        this.capacity = capacity;
        this.fuelLevel = fuelLevel;
        this.fuelType = fuelType;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public String getBusID() {
        return this.busID;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public double getFuelLevel() {
        return this.fuelLevel;
    }

    public String getFuelType() {
        return this.fuelType;
    }
}