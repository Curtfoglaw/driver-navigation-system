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

    public String getBusInfo() {
        return this.busID + ", " + this.capacity + ", " + this.fuelLevel + ", " + this.fuelType;
    }

    public String isValidBusID(String busID) {
        if (busID.length() != 8) {
            return "Invalid Bus ID, ID must be exactly 8 characters long.";
        }
        if (!busID.matches("\\d+")) {
            return "Invalid Bus ID, ID must only contain numerical characters.";
        }
        return "Valid Bus ID.";
    }

    public String isValidCapacity(int capacity) {
        if (capacity > this.capacity) {
            return "Invalid bus capacity, capacity must be less than or equal to previous capacity";
        }
        return "Valid bus capacity";
    }

    public String isValidFuelLevel(double fuelLevel) {
        if (fuelLevel < 0.0) {
            return "Fuel level can't be below 0.";
        }
        if (fuelLevel > 100.0) {
            return "Fuel level can't be above 100.";
        }
        return "Fuel level is valid.";
    }

    public String isValidFuelType(String fuelType) {
        if (fuelType.equals("Electricity") || fuelType.equals("Hybrid") || fuelType.equals("Diesel")) {
            return "Valid fuel type.";
        }
        return "Invalid fuel type, fuel type must be Electricity, Hybrid or Diesel.";
    }
}