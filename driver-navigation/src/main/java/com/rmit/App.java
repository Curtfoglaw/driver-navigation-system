package com.rmit;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


// Main area for testing program functionality (not unit tests or integration tests)
public class App 
{
    public static void main(String[] args)
    {
        DriverRepository repo = new DriverRepository();
        Driver driver = new Driver("11!!1111AA", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");
        repo.Add(driver);

        // Testing functionality

        System.out.println(repo.Retrieve("11!!1111AA"));
        System.out.println(repo.Count());
        System.out.println(repo.Count());


    }


}