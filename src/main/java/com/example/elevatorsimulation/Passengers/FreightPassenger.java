package com.example.elevatorsimulation.Passengers;

import com.example.elevatorsimulation.Elevators.direction;
import com.example.elevatorsimulation.SimulationSettings;

public class FreightPassenger extends Passenger {

    @Override
    public boolean requestElevator(direction _direction, SimulationSettings _simulationSettings) {
        return false;
    }

    public FreightPassenger() {
        this.passengerID = 0;
        this.startingFloor = 0;
        this.destinationFloor = 0;
    }

    public FreightPassenger(int _passengerID, int _startFloor, int _endFloor) {
        this.passengerID = _passengerID;
        this.startingFloor = _startFloor;
        this.destinationFloor = _endFloor;
    }
}
