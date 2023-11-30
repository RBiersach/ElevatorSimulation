package com.example.elevatorsimulation;

import com.example.elevatorsimulation.Elevators.Elevator;
import com.example.elevatorsimulation.Passengers.Passenger;

import java.util.ArrayList;

public class Floor {
    ArrayList<Passenger> waitQueue = new ArrayList<>();
    ArrayList<Passenger> completedQueue = new ArrayList<>();
    ArrayList<Elevator> currentElevators = new ArrayList<>();
    public int floorID;

    public boolean loadAndUnload(SimulationSettings _sm) {
        for (int i = 0; i < currentElevators.size(); i++) {
            if (currentElevators.get(i).getCurrentFloor() == floorID) {
                for (int j = 0; j < currentElevators.get(i).getPassengers(floorID).size(); j++) {
                    if (currentElevators.get(i).getPassengers(floorID).get(j).getEndFloor() == floorID) {
                        completedQueue.add(currentElevators.get(i).getPassengers(floorID).get(j));
                        currentElevators.get(i).getPassengers(floorID).remove(j);
                    }
                }
            }
        }
        if (waitQueue.size() > 0) {
            for (int i = 0; i < currentElevators.size(); i++) {
                if (currentElevators.get(i).checkAvailability(_sm)) {
                    currentElevators.get(i).addPassenger(waitQueue.get(0));
                    waitQueue.remove(0);
                }
            }
        }
        for (int i = 0; i < currentElevators.size(); i++) {
            currentElevators.get(i).move(_sm);
        }
        return true;
    }

}
