package com.rmit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        return;
    }

    public String Retrieve(String busID) {
        try {
            myFile = new File("driver-navigation\\src\\BusStorage.txt");
            Scanner scnr = new Scanner(myFile);

            while (scnr.hasNextLine()) {

                String line = scnr.nextLine();
                String[] busInfo = line.split(", ");

                if (busInfo[0].equals(busID)) {
                    scnr.close();
                    System.out.println("Bus found: \n");
                    System.out.println(line);
                    return line;
                }

            }
            scnr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Bus not found");
        return null;
    }

    public void Count() {
        int currentCount = 0;

        try {
            myFile = new File("driver-navigation\\src\\BusStorage.txt");
            Scanner scnr = new Scanner(myFile);

            while (scnr.hasNextLine()) {
                scnr.nextLine();
                currentCount += 1;
            }
            currentCount -= 1;          // Subtract 1 to account for the first line headers
            System.out.println("Number of buses: " + currentCount);
            scnr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}