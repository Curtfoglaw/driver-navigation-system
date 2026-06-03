package com.rmit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BusUnitTests {

    // Unit testing for valid bus ID
    @Test
    public void testB1_validID() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("94826658", 94, 56.0, "Diesel");

        String result = repo.Add(bus);

        assertEquals("Bus added successfully", result);

        repo.clearBusStorage();
    }

    // Unit testing for duplicate bus ID
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

    // Unit testing for ID above character limit
    @Test
    public void testB1_longID() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("123456789", 94, 56.0, "Diesel");

        String result = repo.Add(bus);

        assertEquals("Invalid Bus ID, ID must be exactly 8 characters long.", result);

        repo.clearBusStorage();
    }

    // Unit testing for ID below character minimum
    @Test
    public void testB1_shortID() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("1234567", 94, 56.0, "Diesel");

        String result = repo.Add(bus);

        assertEquals("Invalid Bus ID, ID must be exactly 8 characters long.", result);

        repo.clearBusStorage();
    }

    // Unit testing for ID with non-numerical characters
    @Test
    public void testB1_letterID() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("1fa0tm24", 94, 56.0, "Diesel");

        String result = repo.Add(bus);

        assertEquals("Invalid Bus ID, ID must only contain numerical characters.", result);

        repo.clearBusStorage();
    }

    // Unit testing for bus update with same capacity
    @Test 
    public void testB2_sameCapacity() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("12345678", 100, 56.0, "Diesel");

        repo.Add(bus);

        String result = repo.Update("12345678", "capacity", "100");

        assertEquals("Bus updated successfully", result);

        repo.clearBusStorage();
    }

    // Unit test for bus update with less capacity
    @Test 
    public void testB2_lessCapacity() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("12345678", 100, 56.0, "Diesel");

        repo.Add(bus);

        String result = repo.Update("12345678", "capacity", "80");

        assertEquals("Bus updated successfully", result);

        repo.clearBusStorage();
    }

    // Unit test for bus update with greater capacity
    @Test 
    public void testB2_greaterCapacity() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("12345678", 100, 56.0, "Diesel");

        repo.Add(bus);

        String result = repo.Update("12345678", "capacity", "110");

        assertEquals("Invalid bus capacity, capacity must be less than or equal to previous capacity", result);

        repo.clearBusStorage();
    }
}