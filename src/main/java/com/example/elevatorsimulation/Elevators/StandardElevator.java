package com.example.elevatorsimulation.Elevators;

public class StandardElevator extends Elevator {

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


    public StandardElevator() {
        this.elevatorID = 0;
        this.elevatorType = "STANDARD";
    }

    public StandardElevator(int _elevatorID) {
        this.elevatorID = _elevatorID;
        this.elevatorType = "STANDARD";
    }
}
