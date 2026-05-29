package com.rmit;

public class BusRepository {
    // Add (), Update (), Retrieve (), Count () functions
    public void Add(Bus bus) {
        try {
            writer = new FileWriter("driver-navigation\\src\\BusStorage.txt", true);
            writer.write(bus.getBusID() + ", " + bus.getCapacity() + ", " + bus.getFuelLevel() + ", " + 
                         bus.getFuelType() + "\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void Update() {

    }

    public void Retrieve() {

    }

    public int Count() {

        return 0;
    }
}