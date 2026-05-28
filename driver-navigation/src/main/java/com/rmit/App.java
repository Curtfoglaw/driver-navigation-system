package com.rmit;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App 
{
    public static void main(String[] args)
    {
        // Creating a sort of "pseudo-memory" that can be used to access and store drivers
        // Drivers from this list can then be added to the .txt file, details can be edited etc

        ArrayList<Driver> drivers; 
        drivers = new ArrayList<>();

        Driver driver = new Driver("34@#1234AA", "John", 10, "Heavy", "64|stink|melbourne|victoria|Australia", "10-10-1990");
        DriverRepository repo = new DriverRepository();
        repo.Add(driver);
    }


}