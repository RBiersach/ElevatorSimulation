package com.example.elevatorsimulation.Elevators;

public abstract class Elevator {
    protected int elevatorID;
    protected String elevatorType;

    public abstract boolean move(direction _direction);


}
