package com.rmit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BusIntegrationTests {

    // Integration test to check that a valid bus is stored correctly
    @Test
    public void testBIT1() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("12345678", 70, 84.2, "Electricity");

        repo.Add(bus);

        String result = repo.Retrieve(bus.getBusID());

        assertEquals("12345678, 70, 84.2, Electricity", result);

        repo.clearBusStorage();
    }

    // Integration test to check that invalid buses are not added
    @Test
    public void testBIT2() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("123456789", 70, 84.2, "Electricity");

        repo.Add(bus);

        String result = repo.Retrieve(bus.getBusID());

        assertEquals("Bus not found.", result);

        repo.clearBusStorage();
    }

    // Integration test to check that updates are stored correctly
    @Test
    public void testBIT3() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("12345678", 70, 84.2, "Electricity");

        repo.Add(bus);

        repo.Update("12345678", "capacity", "60");

        String result = repo.Retrieve(bus.getBusID());

        assertEquals("12345678, 60, 84.2, Electricity", result);

        repo.clearBusStorage();
    }

    // Integration test to check that record counts are updated successfully
    @Test
    public void testBIT4() {
        BusRepository repo = new BusRepository();
        int FirstCount = repo.Count();
        assertEquals(FirstCount, 0); 

        Bus bus = new Bus("12345678", 70, 84.2, "Electricity");
        repo.Add(bus);
        
        int SecondCount = repo.Count();
        assertEquals(SecondCount, 1);

        Bus secondBus = new Bus("23456789", 90, 93.7, "Hybrid");
        repo.Add(secondBus);
        
        int ThirdCount = repo.Count();
        assertEquals(ThirdCount, 2);

        repo.clearBusStorage();
    }
}