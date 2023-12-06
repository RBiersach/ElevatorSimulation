package com.example.elevatorsimulation.Elevators;

import com.example.elevatorsimulation.Passengers.Passenger;
import com.example.elevatorsimulation.SimulationSettings;

import java.util.ArrayList;

public abstract class Elevator {
    public int elevatorID;
    public String elevatorType;
    public int currentFloor;
    public int targetFloor;
    public direction _direction;
    public int maximumCapacity;
    public int elevatorRequestPercentage;
    SimulationSettings sm = new SimulationSettings();
    public ArrayList<Passenger> passengers = new ArrayList<Passenger>();

//    public Elevator(Elevator elevator) {
//        this.elevatorID = elevator.elevatorID;
//        this.elevatorType = elevator.elevatorType;
//        this.currentFloor = elevator.currentFloor;
//        this.targetFloor = elevator.targetFloor;
//        this._direction = elevator._direction;
//        this.maximumCapacity = elevator.maximumCapacity;
//        this.elevatorRequestPercentage = elevator.elevatorRequestPercentage;
//        this.sm = elevator.sm;
//        this.passengers = elevator.passengers;
//    }

    public abstract boolean move(SimulationSettings _sm);

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public ArrayList<Passenger> getPassengers(int currentFloor) {
        ArrayList<Passenger> temp = new ArrayList<>();
        for (int i = 0; i < this.passengers.size(); i++) {
            if (this.passengers.get(i).getDestinationFloor() == currentFloor) {
                temp.add(this.passengers.get(i));
            }
        }
        return temp;
    }

    public boolean checkAvailability(SimulationSettings _sm) {
        return true;
    }

    public boolean addPassenger(Passenger p) {
        this.passengers.add(p);
        return true;
    }

}
