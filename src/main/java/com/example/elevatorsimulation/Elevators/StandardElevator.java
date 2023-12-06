package com.example.elevatorsimulation.Elevators;

import com.example.elevatorsimulation.SimulationSettings;

public class StandardElevator extends Elevator {

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


    public StandardElevator() {
        this.elevatorID = 0;
        this.elevatorType = "STANDARD";
        this.currentFloor = 0;
    }

    public StandardElevator(int _elevatorID) {
        this.elevatorID = _elevatorID;
        this.elevatorType = "STANDARD";
        this.currentFloor = 0;
    }
}
