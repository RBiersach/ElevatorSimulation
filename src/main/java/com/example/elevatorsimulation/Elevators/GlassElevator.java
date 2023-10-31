package com.example.elevatorsimulation.Elevators;

public class GlassElevator extends Elevator {

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


    public GlassElevator() {
        this.elevatorID = 0;
        this.elevatorType = "GLASS";
    }

    public GlassElevator(int _elevatorID) {
        this.elevatorID = _elevatorID;
        this.elevatorType = "GLASS";
    }
}
