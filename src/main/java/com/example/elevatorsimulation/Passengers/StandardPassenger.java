package com.example.elevatorsimulation.Passengers;

import com.example.elevatorsimulation.Elevators.direction;
import com.example.elevatorsimulation.SimulationSettings;

public class StandardPassenger extends Passenger{
    @Override
    public boolean requestElevator(direction _direction, SimulationSettings _simulationSettings) {
        return false;
    }
    public StandardPassenger(){
        this.passengerID = 0;
        this.startFloor = 0;
        this.endFloor = 0;
    }
    public StandardPassenger(int _passengerID, int _startFloor, int _endFloor){
        this.passengerID = _passengerID;
        this.startFloor = _startFloor;
        this.endFloor = _endFloor;
    }
}
