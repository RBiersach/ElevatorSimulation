package com.example.elevatorsimulation.Elevators;

import com.example.elevatorsimulation.SimulationSettings;

public class ExpressElevator extends Elevator {

    public boolean move(SimulationSettings _sm) {
        if (_direction == direction.UP) {
            if (currentFloor < _sm.getNumber_of_floors()) {
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
        } else if (_direction == direction.IDLE) {
            return true;
        } else {
            System.out.println("Incorrect Input");
            return false;
        }
    }

    public ExpressElevator() {
        this.elevatorID = 0;
        this.elevatorType = "EXPRESS";
        this.currentFloor = 0;
    }

    public ExpressElevator(int _elevatorID) {
        this.elevatorID = _elevatorID;
        this.elevatorType = "EXPRESS";
        this.currentFloor = 0;
    }
}
