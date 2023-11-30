package com.example.elevatorsimulation.Elevators;

import com.example.elevatorsimulation.SimulationSettings;

public class GlassElevator extends Elevator {

    public boolean move(SimulationSettings _sm) {
        if (_direction == direction.UP) {
            if (currentFloor < _sm.getFloors()) {
                this.currentFloor = currentFloor + 1;
                _direction = direction.UP;
                return true;
            } else {
                _direction = direction.DOWN;
                this.currentFloor = currentFloor - 1;
                return true;
            }
        } else if (_direction == direction.DOWN) {
            if (currentFloor > 0) {
                this.currentFloor = currentFloor - 1;
                _direction = direction.DOWN;
                return true;
            } else {
                this.currentFloor = currentFloor + 1;
                _direction = direction.UP;
                return true;
            }
        } else {
            System.out.println("Incorrect Input");
            return false;
        }
    }


    public GlassElevator() {
        this.elevatorID = 0;
        this.elevatorType = "GLASS";
        this.currentFloor = 0;
    }

    public GlassElevator(int _elevatorID) {
        this.elevatorID = _elevatorID;
        this.elevatorType = "GLASS";
        this.currentFloor = 0;
    }
}
