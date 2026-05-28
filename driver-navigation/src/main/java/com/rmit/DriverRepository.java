package com.rmit;
import java.io.FileWriter;
import java.io.IOException;

public class DriverRepository {

    FileWriter writer;
    
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
    public void Retrieve() {
        return;
    }
    public int Count() {
        return 0;
    }
}
