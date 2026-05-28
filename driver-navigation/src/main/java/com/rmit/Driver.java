package com.rmit;

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
}
