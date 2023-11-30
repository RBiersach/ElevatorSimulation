package com.example.elevatorsimulation.Elevators;

import com.example.elevatorsimulation.Passengers.Passenger;
import com.example.elevatorsimulation.SimulationSettings;

import java.util.ArrayList;

public abstract class Elevator {
    protected int elevatorID;
    protected String elevatorType;
    protected int currentFloor;
    protected int targetFloor;
    protected direction _direction;
    SimulationSettings sm = new SimulationSettings();
    ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public abstract boolean move(SimulationSettings _sm);

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public ArrayList<Passenger> getPassengers(int currentFloor) {
        ArrayList<Passenger> temp = new ArrayList<>();
        for (int i = 0; i < this.passengers.size(); i++) {
            if (this.passengers.get(i).getEndFloor() == currentFloor) {
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
