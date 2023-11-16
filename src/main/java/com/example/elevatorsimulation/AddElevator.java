package com.example.elevatorsimulation;

public class AddElevator {
    public String elevatorType;
    public int maximumCapacity;
    public int elevatorRequestPercentage;

    public String getElevatorType() {
        return elevatorType;
    }

    public void setElevatorType(String elevatorType) {
        this.elevatorType = elevatorType;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getElevatorRequestPercentage() {
        return elevatorRequestPercentage;
    }

    public void setElevatorRequestPercentage(int elevatorRequestPercentage) {
        this.elevatorRequestPercentage = elevatorRequestPercentage;
    }
}
