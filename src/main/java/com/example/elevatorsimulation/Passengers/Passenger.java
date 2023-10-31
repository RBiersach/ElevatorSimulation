package com.example.elevatorsimulation.Passengers;

import com.example.elevatorsimulation.Elevators.direction;
import com.example.elevatorsimulation.SimulationSettings;

public abstract class Passenger {
    protected int passengerID;
    protected int startFloor;
    protected int endFloor;

    public abstract boolean requestElevator(direction _direction, SimulationSettings _simulationSettings);


}
