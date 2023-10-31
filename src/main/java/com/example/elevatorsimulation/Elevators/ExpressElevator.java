package com.example.elevatorsimulation.Elevators;

public class ExpressElevator extends Elevator {

    public boolean move(direction _direction) {
        if (_direction == direction.UP) {
            return true;
        } else if (_direction == direction.DOWN) {
            return true;
        } else {
            System.out.println("Incorrect Input");
            return false;
        }
    }

    public ExpressElevator() {
        this.elevatorID = 0;
        this.elevatorType = "EXPRESS";
    }

    public ExpressElevator(int _elevatorID) {
        this.elevatorID = _elevatorID;
        this.elevatorType = "EXPRESS";
    }
}
