package com.rmit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DriverUnitTests {

    @Test
    public void testD1_ValidDriverID() {

        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AB", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Driver added successfully.", result);
    }

    @Test
    public void testD1_invalidDriverID() {

        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AA", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Driver ID must be unique.", result);
    }

    @Test
    public void testD1_edgeCase() {

        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234Ac", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("The last 2 characters of the ID must be upepr case letters.", result);
    }




}   
