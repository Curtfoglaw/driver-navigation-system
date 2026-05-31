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

        repo.clearDriverStorage();
    }

    @Test
    public void testD1_invalidDriverID() {

        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AA", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Driver ID must be unique.", result);

        repo.clearDriverStorage();
    }

    @Test
    public void testD1_edgeCase() {

        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234Ac", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("The last 2 characters of the ID must be upepr case letters.", result);

        repo.clearDriverStorage();
    }

    // Unit testing for valid address format

    @Test
    public void testD2_ValidDriverAddress() {

        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AD", "John", 5, "Medium", "12|Able St|Melbourne|VIC|Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Driver added successfully.", result);

        repo.clearDriverStorage();

    }

    @Test
    public void testD2_InvalidDriverAddress() {
        
        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AE", "John", 5, "Medium", "12|Able St|Melbourne|VIC|", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Invalid driver address, incorrect formatting.", result);

        repo.clearDriverStorage();
    }

    @Test
    public void testD2_edgeCase() {
        
        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AF", "John", 5, "Medium", "12, Able St, Melbourne, VIC, Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Invalid driver address, incorrect formatting.", result);

        repo.clearDriverStorage();
    }

    // Unit testing for valid birthdate format

    @Test
    public void testD3_ValidBirthdateFormat() {
        
        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AG", "John", 5, "Medium", "12|Able St|Melbourne|VIC|Australia", "12-05-1990");

        String result = repo.Add(driver);

        assertEquals("Driver added successfully.", result);

        repo.clearDriverStorage();
    }

    @Test
    public void testD3_InvalidBirthdateFormat() {
        
        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AH", "John", 5, "Medium", "12|Able St|Melbourne|VIC|Australia", "12-05-");

        String result = repo.Add(driver);

        assertEquals("Invalid driver birthdate, incorrect formatting.", result);

        repo.clearDriverStorage();
    }

    @Test
    public void testD3_edgeCase() {
        
        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AI", "John", 5, "Medium", "12|Able St|Melbourne|VIC|Australia", "12/05/1990");

        String result = repo.Add(driver);

        assertEquals("Invalid driver birthdate, incorrect formatting.", result);

        repo.clearDriverStorage();
    }

    // Unit testing for license update restrictions

    @Test
    public void testD4_ValidLicenseUpdate() {

        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AJ", "John", 5, "Medium", "12|Able St|Melbourne|VIC|Australia", "12-05-1990");

        repo.Add(driver);

        String result = repo.Update("34@#1234AJ", "licenseType", "Heavy");

        assertEquals("Driver updated successfully.", result);

        repo.clearDriverStorage();

    }

    @Test
    public void testD4_InvalidLicenseUpdate() {

        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AK", "John", 11, "Medium", "12|Able St|Melbourne|VIC|Australia", "12-05-1990");

        repo.Add(driver);

        String result = repo.Update("34@#1234AK", "licenseType", "Heavy");

        assertEquals("Driver's license type cannot be updated.", result);

        repo.clearDriverStorage();

    }

    @Test
    public void testD4_edgeCase() {

        DriverRepository repo = new DriverRepository();

        Driver driver = new Driver("34@#1234AL", "John", 10, "Medium", "12|Able St|Melbourne|VIC|Australia", "12-05-1990");

        repo.Add(driver);

        String result = repo.Update("34@#1234AL", "licenseType", "Heavy");

        assertEquals("Driver updated successfully.", result);

        repo.clearDriverStorage();

    }


}   
