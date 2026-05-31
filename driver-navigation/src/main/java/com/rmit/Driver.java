package com.rmit;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

// This is the driver class
// Drivers will be stored in an array list of other drivers 
// This array list will act as a way for "driver memory" to persist across .txt files

public class Driver {
    
    private String driverID;
    private String name;
    private int experienceYears;
    private String licenseType; 
    private String address;
    private String birthdate;

    public Driver(String driverID, String name, int experienceYears, String licenseType, String address, String birthdate) {
        this.driverID = driverID;
        this.name = name;
        this.experienceYears = experienceYears;
        this.licenseType = licenseType;
        this.address = address;
        this.birthdate = birthdate;
    }

    public void setDriverExperience(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setDriverLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public void setDriverAddress(String address) {
        this.address = address;
    }

    public String getDriverID() {
        return this.driverID;
    }

    public String getDriverName() {
        return this.name;
    }

    public int getDriverExperienceYrs() {
        return this.experienceYears;
    }

    public String getDriverLicenseType() {
        return this.licenseType;
    }

    public String getDriverAddress() {
        return this.address;
    }

    public String getDriverBirthDate() {
        return this.birthdate;
    }

    public String getDriverInfo() {
        return this.driverID + ", " + this.name + ", " + this.experienceYears + ", " + this.licenseType + ", " + this.address + ", " + this.birthdate;
    }

    // Method for checking if the driver ID follows the basic requirements
    public static String isValidDriverID(String driverID) {
        if (driverID.length() != 10) {
            return "Invalid driver ID. ID must be exactly 10 characters long.";
        }
        else if (!Character.isDigit(driverID.charAt(0)) || !Character.isDigit(driverID.charAt(1))) {
            return "Characters at position 1 and 2 in the ID must be numbers between 1 and 2.";
        }
        else if (driverID.charAt(0) < '2' || driverID.charAt(1) < '2') {
            return "Characters at position 1 and 2 in the ID must be numbers between 2 and 9.";
        }
        else if (!Character.isUpperCase(driverID.charAt(8)) || !Character.isUpperCase(driverID.charAt(9))) {
            return "The last 2 characters of the ID must be upepr case letters.";
        }
        else {
            int specialCharacterCount = 0;
            for (int i = 2; i < 8; i++) {
                if (!Character.isLetterOrDigit(driverID.charAt(i))) {
                    specialCharacterCount += 1;
                }
            }
            if (specialCharacterCount < 2) {
                return "There must be at least 2 special characters between character 3 and character 8 in the driver ID.";
            }
        }
        return "Driver ID is valid";
    }

    // Method for checking if the driver address is the correct format

    public static String isValidDriverAddress(String address) {
        String[] addressParts = address.split("\\|");

        if (addressParts.length != 5) {
            return "Invalid driver address, incorrect formatting.";
        }
        for (String part : addressParts) {
            if (part.trim().isEmpty()) {
                return "Invalid driver address, incorrect formatting.";
            }
        }
        return "Valid formatting for driver address.";
        
    }

    // Method for checking if the driver address is the correct format

    public static String isValidDriverBirthDate(String birthdate) {
        String[] birthdateParts = birthdate.split("-");

        if (birthdateParts.length != 3) {
            return "Invalid driver birthdate, incorrect formatting.";
        }
        for (String part : birthdateParts) {
            if (part.trim().isEmpty()) {
                return "Invalid driver birthdate, incorrect formatting.";
            }
        }
        for (int i = 0; i < birthdateParts.length - 1; i++) {
            if (birthdateParts[i].length() != 2) {
                return "Invalid driver birthdate, incorrect formatting.";
            }
        }
        if (birthdateParts[2].length() != 4) {
            return "Invalid driver birthdate, incorrect formatting.";
        }
        return "Valid formatting for driver birthdate.";
    }

    // Method for checking if a driver's license type can be updated

    public static String canUpdateLicenseType(int experienceYears) {
        if (experienceYears > 10) {
            return "Driver's license type cannot be updated.";
        }
        return "Driver's license type can be updated.";
    }
}
