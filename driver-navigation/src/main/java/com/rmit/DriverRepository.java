package com.rmit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DriverRepository {

    FileWriter writer;
    File myFile;

    // Function for adding a driver to the .txt file
    public void Add(Driver driver) {
        try {
            writer = new FileWriter("driver-navigation\\src\\DriverStorage.txt", true);
            writer.write(driver.getDriverID() + ", " + driver.getDriverName() + ", " + driver.getDriverExperienceYrs() + ", " + 
                         driver.getDriverLicenseType() + ", " + driver.getDriverAddress() + ", " + driver.getDriverBirthDate() + "\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void Update() {
        return;
    }

    // Function for retrieving the details of a driver from the .txt file given their ID
    public String Retrieve(String driverID) {
        try {
            myFile = new File("driver-navigation\\src\\DriverStorage.txt");
            Scanner scnr = new Scanner(myFile);

            while (scnr.hasNextLine()) {

                String line = scnr.nextLine();
                String[] driverInfo = line.split(", ");

                if (driverInfo[0].equals(driverID)) {
                    scnr.close();
                    System.out.println("Driver found: \n");
                    System.out.println(line);
                    return line;
                }

            }
            scnr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Driver not found");
        return null;

    }

    // Function to see how many drivers are currently stored in the .txt file
    public void Count() {
        int currentCount = 0;

        try {
            myFile = new File("driver-navigation\\src\\DriverStorage.txt");
            Scanner scnr = new Scanner(myFile);

            while (scnr.hasNextLine()) {
                scnr.nextLine();
                currentCount += 1;
            }
            currentCount -= 1;          // Subtract 1 to account for the first line headers
            System.out.println("Number of drivers: " + currentCount);
            scnr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
