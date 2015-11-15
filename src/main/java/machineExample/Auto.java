package machineExample;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by dkorolev on 11/15/15.
 */
public class Auto {

    private String brand;

    private int numOfSeats;

    private Driver driver;

    private LocalDateTime dateOfCreation;

    private int sizeOfTank;

    private int maxSpeed;



    public Auto(String brand, int numOfSeats, Driver driver, LocalDateTime dateOfCreation, int sizeOfTank, int maxSpeed) {
        this.brand = brand;
        this.numOfSeats = numOfSeats;
        this.driver = driver;
        this.dateOfCreation = dateOfCreation;
        this.sizeOfTank = sizeOfTank;
        this.maxSpeed = maxSpeed;
    }


    //methods
    public int whatIsMaxDistance(int sizeOfTank, int maxSpeed) {
        return (int) ((sizeOfTank*maxSpeed)*0.8);
    }


    //getters and setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getSizeOfTank() {
        return sizeOfTank;
    }

    public void setSizeOfTank(int sizeOfTank) {
        this.sizeOfTank = sizeOfTank;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
