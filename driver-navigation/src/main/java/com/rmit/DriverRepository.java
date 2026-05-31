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


    // Function for adding a driver to the .txt file
    public String Add(Driver driver) {

        String validOrNotID = Driver.isValidDriverID(driver.getDriverID());
        String validOrNotAddress = Driver.isValidDriverAddress(driver.getDriverAddress());
        String validOrNotBirthdate = Driver.isValidDriverBirthDate(driver.getDriverBirthDate());

        if (Retrieve(driver.getDriverID()) != "Driver not found") {
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
        else {
            try {
                writer  = new FileWriter("DriverStorage.txt", true);
                writer.write(driver.getDriverID() + ", " + driver.getDriverName() + ", " + driver.getDriverExperienceYrs() + ", " + 
                            driver.getDriverLicenseType() + ", " + driver.getDriverAddress() + ", " + driver.getDriverBirthDate() + "\n");
                writer.close();
                return "Driver added successfully.";
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }


    // Function for updating the contents of a driver
    public String Update(String driverID, String field, String newValue) {

    
        try {
            myFile = new File("DriverStorage.txt");
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
                            return "Could not change detail. Either user entered invalid detail (ID, name, age) or didn't select valid field.";
                    }
                    lines.set(i, String.join(", ", driverInfo));
                    writer = new FileWriter("DriverStorage.txt", false);
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

    // Function for retrieving the details of a driver from the .txt file given their ID
    public String Retrieve(String driverID) {
        try {
            myFile = new File("DriverStorage.txt");
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
        return "Driver not found";

    }

    // Function to see how many drivers are currently stored in the .txt file
    public int Count() {
        int currentCount = 0;

        try {
            myFile = new File("DriverStorage.txt");
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
        try (FileWriter fw = new FileWriter("DriverStorage.txt")) {
            fw.write("driverID, name, experienceYears, licenseType, address, birthdate" + "\n");
            fw.write("34@#1234AA, John, 5, Medium, 12|Main St|Melbourne|VIC|Australia, 12-05-1990" + "\n");          

        } 
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
