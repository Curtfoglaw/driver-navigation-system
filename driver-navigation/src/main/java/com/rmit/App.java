package com.rmit;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class App 
{
    public static void main(String[] args)
    {
        Driver driver = new Driver("34@#1234AA", "John", 10, "Heavy", "64|stink|melbourne|victoria|Australia", "10-10-1990");
        DriverRepository repo = new DriverRepository();
        repo.Add(driver);
    }


}