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
    String fileRouteString = "";

    private boolean appTestingTrue = false;

    public BusRepository() {
        this(false);
    }

    public BusRepository(boolean appTestingTrue) {
        this.appTestingTrue = appTestingTrue;

        if (this.appTestingTrue == true) {
            fileRouteString = "driver-navigation\\";
        } else {
            fileRouteString = ""; 
        }
    }


    public String Add(Bus bus) {
        String validOrNotID = bus.isValidBusID(bus.getBusID());
        String validOrNotFuelType = bus.isValidFuelType(bus.getFuelType());
        String validOrNotFuelLevel = bus.isValidFuelLevel(bus.getFuelLevel());

        if (!Retrieve(bus.getBusID()).equals("Bus not found.")) {
            return "Bus ID must be unique.";
        }
        if (!validOrNotID.equals("Valid Bus ID.")) {
            return validOrNotID;
        }
        if (!validOrNotFuelType.equals("Valid fuel type.")) {
            return validOrNotFuelType;
        }
        if (!validOrNotFuelLevel.equals("Fuel level is valid.")) {
            return validOrNotFuelLevel;
        }
        try {
            writer = new FileWriter(fileRouteString + "BusStorage.txt", true);
            writer.write(bus.getBusID() + ", " + bus.getCapacity() + ", " + bus.getFuelLevel() + ", " + 
                         bus.getFuelType() + "\n");
            writer.close();
            return "Bus added successfully";
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "Bus could not be added";
    }

    public String Update(String busID, String field, String newValue) {
        try {
            myFile = new File(fileRouteString + "BusStorage.txt");
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
                            int capacity = Integer.parseInt(newValue);
                            int oldCapacity = Integer.parseInt(busInfo[1]);
                            if (capacity > oldCapacity) {
                                return "Invalid bus capacity, capacity must be less than or equal to previous capacity";
                            }
                            busInfo[1] = newValue;
                            break;
                        case "fuelLevel":
                            double fuelLevel = Double.parseDouble(newValue);
                            if (fuelLevel > 100.0) {
                                return "Fuel level can't be above 100.";
                            }
                            if (fuelLevel < 0.0) {
                                return "Fuel level can't be below 0.";
                            }
                            busInfo[2] = newValue;
                            break;
                        default:
                            return "Could not change detail. Either user entered invalid detail (ID, Capacity, Fuel Level) or didn't select valid field";
                    }
                    lines.set(i, String.join(", ", busInfo));
                    FileWriter writer = new FileWriter(fileRouteString + "BusStorage.txt");

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
            myFile = new File(fileRouteString + "BusStorage.txt");
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
        return "Bus not found.";
    }

    public int Count() {
        int currentCount = 0;

        try {
            myFile = new File(fileRouteString + "BusStorage.txt");
            Scanner scnr = new Scanner(myFile);

            while (scnr.hasNextLine()) {
                scnr.nextLine();
                currentCount += 1;
            }
            currentCount -= 1;          // Subtract 1 to account for the first line headers
            scnr.close();
            System.out.println("Number of buses: " + currentCount);
            return currentCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void clearBusStorage() {
        try (FileWriter fw = new FileWriter(fileRouteString + "BusStorage.txt")) {
            fw.write("busID, Capacity, fuelLevel, fuelType " + "\n");         
        } 
        catch (IOException e){
            e.printStackTrace();
        }

    }
}