package com.example.elevatorsimulation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SimulationSettings {
    int floors;
    public ArrayList<AddPassenger> add_passenger = new ArrayList<>();
    public ArrayList<PassengerRequestPercentage> passenger_request_percentage = new ArrayList<>();
    public int number_of_elevators;

    //How many iterations
    public int run_simulation;

    @Override
    public String toString() {
        return super.toString();
    }
}
