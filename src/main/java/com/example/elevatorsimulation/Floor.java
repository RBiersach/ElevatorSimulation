package com.example.elevatorsimulation;

import com.example.elevatorsimulation.Elevators.Elevator;
import com.example.elevatorsimulation.Passengers.Passenger;

import java.util.ArrayList;

public class Floor {
    ArrayList<Passenger> waitQueue = new ArrayList<>();
    ArrayList<Passenger> completedQueue = new ArrayList<>();
    ArrayList<Elevator> currentElevatos = new ArrayList<>();

}
