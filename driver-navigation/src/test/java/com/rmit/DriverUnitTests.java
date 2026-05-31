package com.rmit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DriverUnitTests {

    // Unit testing for valid driver ID

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

    // Unit testing for valid address format

    @Test
    public void testD2_ValidDriverAddress() {

        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AD", "John", 5, "Medium", "12|Able St|Melbourne|VIC|Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Driver added successfully.", result);

    }

    @Test
    public void testD2_InvalidDriverAddress() {
        
        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AE", "John", 5, "Medium", "12|Able St|Melbourne|VIC|", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Invalid driver address, incorrect formatting.", result);
    }

    @Test
    public void testD2_edgeCase() {
        
        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AF", "John", 5, "Medium", "12, Able St, Melbourne, VIC, Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Invalid driver address, incorrect formatting.", result);
    }

    // Unit testing for valid birthdate format

    @Test
    public void testD3_ValidBirthdateFormat() {
        
        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AG", "John", 5, "Medium", "12|Able St|Melbourne|VIC|Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Driver added successfully.", result);
    }

    @Test
    public void testD3_InvalidBirthdateFormat() {
        
        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AH", "John", 5, "Medium", "12|Able St|Melbourne|VIC|Australia", "12-05-");

        String result = repo.Add(driver);

        assertEquals("Invalid driver birthdate, incorrect formatting.", result);
    }

    @Test
    public void testD3_edgeCase() {
        
        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AI", "John", 5, "Medium", "12|Able St|Melbourne|VIC|Australia", "12/05/1990");

        String result = repo.Add(driver);

        assertEquals("Invalid driver birthdate, incorrect formatting.", result);
    }







}   
