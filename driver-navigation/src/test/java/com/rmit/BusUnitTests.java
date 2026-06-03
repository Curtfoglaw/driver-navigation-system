package com.rmit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BusUnitTests {

    // Unit testing for valid bus ID
    @Test
    public void testB1_validID() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("12345678", 94, 56.0, "Diesel");

        String result = repo.Add(bus);

        assertEquals("Bus added successfully", result);

        repo.clearBusStorage();
    }

    @Test
    public void testB1_duplicateID() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("12345678", 94, 56.0, "Diesel");

        repo.Add(bus);

        Bus newBus = new Bus("12345678", 94, 56.0, "Diesel");

        String result = repo.Add(newBus);

        assertEquals("Bus ID must be unique.", result);

        repo.clearBusStorage();
    }
}