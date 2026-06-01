package com.rmit;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


// Main area for testing program functionality (not unit tests or integration tests)
public class App 
{
    public static void main(String[] args)
    {   
        System.out.println("Starting in App.java");
        DriverRepository repo = new DriverRepository(true); 

        repo.Count();

        Driver driver = new Driver("22!!1111AA", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");
        String addResult = repo.Add(driver);
        System.out.println("Add result: " + addResult);

        repo.Count();
    }


}