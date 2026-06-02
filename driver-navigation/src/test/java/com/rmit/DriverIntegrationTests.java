package com.rmit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DriverIntegrationTests {


    // Integration test to check that a valid driver is stored correctly
    @Test
    public void TestDIT1() {
        
        DriverRepository repo = new DriverRepository();
        Driver driver = new Driver("34@#1234NL", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");
        repo.Add(driver);
        String result = repo.Retrieve("34@#1234NL");
        String expectedResult = driver.getDriverInfo();

        assertEquals(expectedResult, result);

        repo.clearDriverStorage();
    }   

    // Integration test to check that an invalid driver is rejected and not in the .txt file
    @Test
    public void TestDIT2() {
        
        DriverRepository repo = new DriverRepository();
        Driver driver = new Driver("34@#1234bb", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");
        repo.Add(driver);
        String result = repo.Retrieve(driver.getDriverID());


        assertEquals("Driver not found.", result);

        repo.clearDriverStorage();
    }   

    // Integration test to check that updates are persisted correctly
    @Test
    public void TestDIT3() {
        
        DriverRepository repo = new DriverRepository();
        Driver driver = new Driver("34@#1234CC", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");
        repo.Add(driver);
        
        repo.Update(driver.getDriverID(), "licenseType", "Heavy");

        String updatedDetails = repo.Retrieve(driver.getDriverID());
        
        assertEquals("34@#1234CC, John, 5, Heavy, 12|Main St|Melbourne|VIC|Australia, 12-05-1990", updatedDetails);

        repo.clearDriverStorage();
    }   

    // Integration test to check that record counts are updated successfully
    @Test
    public void TestDIT4() {

        DriverRepository repo = new DriverRepository();
        int FirstCount = repo.Count();
        assertEquals(FirstCount, 0);    // Should have no drivers yet

        Driver driver1 = new Driver("34@#1234ZZ", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");
        repo.Add(driver1);
        int secondCount = repo.Count();
        assertEquals(secondCount, 1);

        Driver driver2 = new Driver("34@#1234PP", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");
        repo.Add(driver2);
        int thirdCount = repo.Count();
        assertEquals(thirdCount, 2);

    }


}
