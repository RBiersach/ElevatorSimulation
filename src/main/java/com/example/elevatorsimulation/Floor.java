package com.example.elevatorsimulation;

import com.example.elevatorsimulation.Elevators.Elevator;
import com.example.elevatorsimulation.Passengers.Passenger;

import java.util.ArrayList;

public class Floor {
    //    ArrayList<Passenger> waitQueue;
//    ArrayList<Passenger> completedQueue = new ArrayList<>();
//    ArrayList<Elevator> currentElevators;
    public int floorID;
    SimulationSettings sm;

//    public boolean loadAndUnload() {
//        for (int i = 0; i < currentElevators.size(); i++) {
//            if (currentElevators.get(i).getCurrentFloor() == floorID) {
//                for (int j = 0; j < currentElevators.get(i).getPassengers(floorID).size(); j++) {
//                    if (currentElevators.get(i).getPassengers(floorID).get(j).getDestinationFloor() == floorID) {
//                        completedQueue.add(currentElevators.get(i).getPassengers(floorID).get(j));
//                        currentElevators.get(i).getPassengers(floorID).remove(j);
//                    }
//                }
//            }
//        }
//        if (waitQueue.size() > 0) {
//            for (int i = 0; i < currentElevators.size(); i++) {
//                if (currentElevators.get(i).maximumCapacity > currentElevators.get(i).passengers.size()) {
//                    currentElevators.get(i).addPassenger(waitQueue.get(0));
//                    waitQueue.remove(0);
//                }
//            }
//        }
//        for (int i = 0; i < this.sm.number_of_elevators; i++) {
//            currentElevators.get(i).move(this.sm);
//        }
//        return true;
//    }

    public Floor(int _floorID, SimulationSettings _sm) {
        this.floorID = _floorID;
        this.sm = _sm;
//        this.currentElevators = _sm.getElevators();
//        this.waitQueue = new ArrayList<>();
//        for (int i = 0; i < _sm.passengers.size(); i++) {
//            if (_sm.passengers.get(i).getStartingFloor() == _floorID) {
//                waitQueue.add(_sm.passengers.get(i));
//            }
//        }
    }

}
