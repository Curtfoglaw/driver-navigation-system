package com.rmit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class BusRepository {
    
    FileWriter writer;
    File myFile;

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

    public String Update(String busID, int capacity, double fuelLevel) {
        try {
            myFile = new File("driver-navigation\\src\\BusStorage.txt");
            Scanner scnr = new Scanner(myFile);
            ArrayList<String> lines = new ArrayList<>();

            while (scnr.hasNextLine()) {
                lines.add(scnr.nextLine());
            }
            scnr.close();

            for (int i = 1; i < lines.size(); i++) {

                String[] busInfo = lines.get(i).split(", ");

                if (busInfo[0].equals(busID)) {

                    switch (field) {
                        case "capacity":
                            busInfo[1] = newValue;
                            break;
                        case "fuelLevel":
                            busInfo[2] = newValue;
                            break;
                        default:
                            return "Could not change detail. Either user entered invalid detail (ID, Capacity, Fuel Level) or didn't select valid field";
                    }
                    lines.set(i, String.join(", ", busInfo));
                    FileWriter writer = new FileWriter("driver-navigation\\src\\BusStorage.txt");

                    for (String line : lines) {
                        writer.write(line + "\n");
                    }
                    writer.close();
                    return "Bus updated successfully";
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Bus not found");
        return null;
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

    public int Count() {
        int currentCount = 0;

        try {
            myFile = new File("driver-navigation\\src\\BusStorage.txt");
            Scanner scnr = new Scanner(myFile);

            while (scnr.hasNextLine()) {
                scnr.nextLine();
                currentCount += 1;
            }
            currentCount -= 1;          // Subtract 1 to account for the first line headers
            scnr.close();
            return currentCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}