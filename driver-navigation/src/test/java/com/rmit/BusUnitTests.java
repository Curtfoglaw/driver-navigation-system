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

    // Unit test for driver over 50 driving sub 50 capacity bus
    @Test 
    public void testB3_oldDriverLowCapacity() {
        BusRepository repo = new BusRepository();

        Bus bus = new Bus("12345678", 40, 56.0, "Diesel");

        repo.Add(bus);

        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Medium", 56, 22);

        assertEquals("Driver can use this vehicle", result);

        repo.clearBusStorage();
    }
    // Unit test for driver under 50 driving sub 50 capacity bus
    @Test
    public void testB3_youngDriverLowCapacity() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 40, 37.0, "Diesel");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Medium", 37, 5);
        assertEquals("Driver can use this vehicle", result);
        repo.clearBusStorage();
    }

    // Unit test for driver over 50 driving over 50 capacity bus
    @Test
    public void testB3_oldDriverHighCapacity() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 64, 56.0, "Diesel");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Medium", 56, 5);
        assertEquals("Driver cannot use this vehicle, capacity over 50 for driver over 50", result);
        repo.clearBusStorage();
    }

    // Unit test for driver under 50 driving over 50 capacity bus
    @Test
    public void testB3_youngDriverHighCapacity() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 64, 37.0, "Diesel");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Medium", 37, 5);
        assertEquals("Driver can use this vehicle", result);
        repo.clearBusStorage();
    }

    // Unit test for driver over 50 driving 50 capacity bus
    @Test
    public void testB3_oldDriverFiftyCapacity() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 50, 56.0, "Diesel");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Medium", 56, 5);
        assertEquals("Driver cannot use this vehicle, capacity over 50 for driver over 50", result);
        repo.clearBusStorage();
    }

    // Unit test for driver over 50 driving 50 capacity bus
    @Test
    public void testB3_youngDriverFiftyCapacity() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 50, 37.0, "Diesel");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Medium", 37, 5);
        assertEquals("Driver can use this vehicle", result);
        repo.clearBusStorage();
    }

    // Unit test for driver with 5 years experience driving electric bus
    @Test
    public void testB4_fiveYearsElectricBus() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 40, 45.0, "Electricity");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Heavy", 45, 5);
        assertEquals("Driver can use this vehicle", result);
        repo.clearBusStorage();
    }

    // Unit test for driver with more than 5 years experience driving electric bus
    @Test
    public void testB4_moreYearsElectricBus() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 40, 45.0, "Electricity");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Heavy", 45, 7);
        assertEquals("Driver can use this vehicle", result);
        repo.clearBusStorage();
    }

    // Unit test for driver with less than 5 years experience driving electric bus
    @Test
    public void testB4_lessYearsElectricBus() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 40, 45.0, "Electricity");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Heavy", 45, 3);
        assertEquals("Driver cannot use this vehicle, need 5 years experience for electric buses", result);
        repo.clearBusStorage();
    }

    // Unit test for driver with a heavy license driving a hybrid bus
    @Test
    public void testB5_heavyHybrid() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 40, 45.0, "Hybrid");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Heavy", 45, 5);
        assertEquals("Driver can use this vehicle", result);
        repo.clearBusStorage();
    }

    // Unit test for driver with public transport license driving a hybrid bus
    @Test
    public void testB5_publicHybrid() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 40, 45.0, "Hybrid");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Public Transport", 45, 5);
        assertEquals("Driver can use this vehicle", result);
        repo.clearBusStorage();
    }

    // Unit test for driver with a medium license driving a hybrid bus
    @Test
    public void testB5_mediumHybrid() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 40, 45.0, "Hybrid");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Medium", 45, 5);
        assertEquals("Driver cannot use this vehicle, hybrid and electric vehicles require heavy or public transport licence", result);
        repo.clearBusStorage();
    }

    // Unit test for driver with a heavy license driving an electric bus
    @Test
    public void testB5_heavyElectric() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 40, 45.0, "Electricity");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Heavy", 45, 5);
        assertEquals("Driver can use this vehicle", result);
        repo.clearBusStorage();
    }

    // Unit test for driver with public transport license driving a hybrid bus
    @Test
    public void testB5_publicElectric() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 40, 45.0, "Electricity");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Public Transport", 45, 5);
        assertEquals("Driver can use this vehicle", result);
        repo.clearBusStorage();
    }

    // Unit test for driver with a medium license driving an electric bus
    @Test
    public void testB5_mediumElectric() {
        BusRepository repo = new BusRepository();
        Bus bus = new Bus("12345678", 40, 45.0, "Electricity");
        repo.Add(bus);
        String result = repo.validDriver(bus.getCapacity(), bus.getFuelType(), "Medium", 45, 5);
        assertEquals("Driver cannot use this vehicle, hybrid and electric vehicles require heavy or public transport licence", result);
        repo.clearBusStorage();
    }
}