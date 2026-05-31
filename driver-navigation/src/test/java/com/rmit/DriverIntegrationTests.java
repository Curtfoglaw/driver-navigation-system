package com.rmit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DriverIntegrationTests {


    // Integration test to check that a valid driver is stored correctly
    @Test
    public void TestDIT1() {
        
        DriverRepository repo = new DriverRepository();
        Driver driver = new Driver("34@#1234AB", "John", 5, "Medium", "12|Main St|Melbourne|VIC|Australia", "12-05-1990");
        repo.Add(driver);
        String result = repo.Retrieve(driver.getDriverID());
        String expectedResult = driver.getDriverInfo();

        assertEquals(expectedResult, result);

        repo.clearDriverStorage();
    }   


}
