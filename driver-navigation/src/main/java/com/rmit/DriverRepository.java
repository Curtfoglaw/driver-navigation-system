package com.rmit;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverRepository {

    FileWriter writer;
    File myFile;
    String fileRouteString = "";

    private boolean appTestingTrue = false;

    public DriverRepository() {
        this(false);
    }

    public DriverRepository(boolean appTestingTrue) {
        this.appTestingTrue = appTestingTrue;

        if (this.appTestingTrue == true) {
            fileRouteString = "driver-navigation\\";
        } else {
            fileRouteString = ""; 
        }
    }


    // Function for adding a driver to the DriverStorage.txt file
    public String Add(Driver driver) {

        String validOrNotID = Driver.isValidDriverID(driver.getDriverID());
        String validOrNotAddress = Driver.isValidDriverAddress(driver.getDriverAddress());
        String validOrNotBirthdate = Driver.isValidDriverBirthDate(driver.getDriverBirthDate());

        if (!Retrieve(driver.getDriverID()).equals("Driver not found.")) {
            return "Driver ID must be unique.";
        }
        if (!validOrNotID.equals("Driver ID is valid")) {
            return validOrNotID;
        }
        if (!validOrNotAddress.equals("Valid formatting for driver address.")) {
            return validOrNotAddress;
        }
        if (!validOrNotBirthdate.equals("Valid formatting for driver birthdate.")) {
            return validOrNotBirthdate;
        }
        try {
            writer  = new FileWriter(fileRouteString + "DriverStorage.txt", true);
            writer.write(driver.getDriverID() + ", " + driver.getDriverName() + ", " + driver.getDriverExperienceYrs() + ", " + 
                        driver.getDriverLicenseType() + ", " + driver.getDriverAddress() + ", " + driver.getDriverBirthDate() + "\n");
            writer.close();
            return "Driver added successfully.";
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "Driver ould not be added.";
    }


    // Function for updating the contents of a driver
    public String Update(String driverID, String field, String newValue) {
    
        try {
            myFile = new File(fileRouteString + "DriverStorage.txt");
            Scanner scnr = new Scanner(myFile);
            ArrayList<String> lines = new ArrayList<>();

            while (scnr.hasNextLine()) {
                lines.add(scnr.nextLine());
            }
            scnr.close();

            for (int i = 1; i < lines.size(); i++) {

                String[] driverInfo = lines.get(i).split(", ");

                if (driverInfo[0].equals(driverID)) {

                    switch (field) {
                        case "experienceYears":
                            driverInfo[2] = newValue;
                            break;
                        case "licenseType":
                            if (!Driver.canUpdateLicenseType(Integer.parseInt(driverInfo[2])).equals("Driver's license type can be updated.")) {
                                return Driver.canUpdateLicenseType(Integer.parseInt(driverInfo[2]));
                            }
                            driverInfo[3] = newValue;
                            break;
                        case "address":

                            driverInfo[4] = newValue;
                            
                            break;
                        default:
                            return "Could not change detail. Field entered is not valid for update.";
                    }
                    lines.set(i, String.join(", ", driverInfo));
                    writer = new FileWriter(fileRouteString + "DriverStorage.txt", false);
                    for (String line : lines) {
                        writer.write(line + "\n");
                    }
                    writer.close();
                    return "Driver updated successfully.";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Driver not found.";

    }

    // Function for retrieving the details of a driver from the DriverStorage.txt file given their ID
    public String Retrieve(String driverID) {
        try {
            myFile = new File(fileRouteString + "DriverStorage.txt");
            Scanner scnr = new Scanner(myFile);
            scnr.nextLine();
            while (scnr.hasNextLine()) {

                String line = scnr.nextLine();
                String[] driverInfo = line.split(", ");

                if (driverInfo[0].equals(driverID)) {
                    scnr.close();
                    return line;
                }

            }
            scnr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Driver not found.";

    }

    // Function to see how many drivers are currently stored in the DriverStorage.txt file
    public int Count() {

        int currentCount = 0;
        try {
            myFile = new File(fileRouteString + "DriverStorage.txt");
            Scanner scnr = new Scanner(myFile);

            while (scnr.hasNextLine()) {
                scnr.nextLine();
                currentCount += 1;
            }
            currentCount -= 1;          // Subtract 1 to account for the first line headers
            System.out.println("Number of drivers: " + currentCount);
            scnr.close();
            return currentCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public void clearDriverStorage() {
        try (FileWriter fw = new FileWriter(fileRouteString + "DriverStorage.txt")) {
            fw.write("driverID, name, experienceYears, licenseType, address, birthdate" + "\n");         

        } 
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
