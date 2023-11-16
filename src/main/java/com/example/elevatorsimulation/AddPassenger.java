package com.example.elevatorsimulation;

public class AddPassenger {
    public int startingFloor;
    public int destinationFloor;
    public String passengerType;
    public double passengerRequestPercentage;

    public int getStartingFloor() {
        return startingFloor;
    }

    public void setStartingFloor(int startingFloor) {
        this.startingFloor = startingFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public double getPassengerRequestPercentage() {
        return passengerRequestPercentage;
    }

    public void setPassengerRequestPercentage(double passengerRequestPercentage) {
        this.passengerRequestPercentage = passengerRequestPercentage;
    }
}
